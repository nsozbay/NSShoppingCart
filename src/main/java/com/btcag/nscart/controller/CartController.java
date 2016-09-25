package com.btcag.nscart.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.btcag.nscart.model.Cart;
import com.btcag.nscart.model.CartItem;
import com.btcag.nscart.model.Product;
import com.btcag.nscart.ops.PricingStrategy;
import com.btcag.nscart.ops.impl.TaxPricingStrategy;
import com.btcag.nscart.ops.impl.TotalPricingStrategy;
import com.btcag.nscart.service.CartItemService;
import com.btcag.nscart.service.CartService;
import com.btcag.nscart.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;
    
    @Autowired
    private ProductService productService;
    
    private PricingStrategy totalStrategy = new TotalPricingStrategy();
    
    private PricingStrategy taxStrategy = new TaxPricingStrategy();
    
    @RequestMapping("/all")
    public String getAllCart(Model model){
        
    	Cart cart = cartService.getCart();
    	List<CartItem> cartItems = cart.getCartItems();
    	model.addAttribute("cartItems",cartItems);
    	
    	model.addAttribute("grandTotal", totalStrategy.calculate(cart.getGrandTotal()));
    	model.addAttribute("taxTotal", (new DecimalFormat("##.##").format(taxStrategy.calculate(cart.getGrandTotal()))));
    	
    	int itemsOnBasket = 0;
    	for (CartItem cartItem : cartItems) {
			itemsOnBasket += cartItem.getQuantity();
		}
    	model.addAttribute("itemsOnBasket", itemsOnBasket);
    	
        return "cart";
    }
    
    @RequestMapping("/get")
    public Cart getCart(){
        return cartService.getCart();
    }

    @RequestMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public void addItem (@RequestParam(value="productId") String productId, 
    		@RequestParam(value="productQuantity") int productQuantity,
    		Model model){

        Cart cart = getCart();
        Product product = productService.getProductById(new ObjectId(productId));
        List<CartItem> cartItems = cart.getCartItems();

        for (int i=0; i < cartItems.size(); i++){
            if(product.getId().toString().equals(cartItems.get(i).getProduct().getId().toString())){
            	CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + productQuantity);
                double priceIncrease = product.getPrice()*productQuantity;
                cartItem.setTotalPrice(totalStrategy.calculate(cartItem.getTotalPrice() + priceIncrease));

                cartItems.set(i, cartItem);
                
                cartItemService.addCartItem(cartItem);
                
                cart.setGrandTotal(totalStrategy.calculate(cart.getGrandTotal() + priceIncrease));
                cart.setCartItems(cartItems);
                cartService.update(cart);

                return;
            }
        }

        double priceIncrease = productQuantity*product.getPrice();
        CartItem cartItem = new CartItem(product, productQuantity, priceIncrease);
        
        cartItems.add(cartItem);
        
        cartItemService.addCartItem(cartItem);
        
        cart.setGrandTotal(totalStrategy.calculate(cart.getGrandTotal() + priceIncrease));
        cart.setCartItems(cartItems);
        cartService.update(cart);

    }

}
