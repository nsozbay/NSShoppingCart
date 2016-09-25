package com.btcag.nscart.controller;

import java.io.IOException;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.btcag.nscart.model.Category;
import com.btcag.nscart.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;
	
	@RequestMapping("/viewCategory/all")
    public String getCategories(Model model){
        List<Category> categories = categoryService.getCategoryList();
        model.addAttribute("categories", categories);
        model.addAttribute("selectedCategory", categories.get(0));

        return "productList";
    }

    @RequestMapping("/viewCategory/{categoryId}")
    public String viewCategory(@PathVariable String categoryId, Model model) throws IOException{
    	List<Category> categories = categoryService.getCategoryList();
        Category category = categoryService.getCategoryById(new ObjectId(categoryId));
        model.addAttribute("categories", categories);
        model.addAttribute("selectedCategory", category);

        return "productList";
    }

}
