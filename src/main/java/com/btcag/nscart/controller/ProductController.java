package com.btcag.nscart.controller;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.btcag.nscart.model.Product;
import com.btcag.nscart.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException{
        Product product = productService.getProductById(new ObjectId(productId));
        model.addAttribute("product", product);

        return "viewProduct";
    }

} // The End of Class;

