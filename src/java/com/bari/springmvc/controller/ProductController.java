package com.bari.springmvc.controller;

import com.bari.springmvc.model.Product;
import com.bari.springmvc.service.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @RequestMapping("/")
    public String listProduct(Map<String, Object> map) {
        map.put("product", new Product());
        map.put("productList", productService.listProduct());
        //System.out.println(productService.listProduct().get(0).getProductName());
        return "index";
    }
    
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("product") Product product, BindingResult result) {
        if (product.getId() == null) {
            productService.addProduct(product);
        } else {
            productService.updateProduct(product);
        }
        return "redirect:/";
    }
    
    @RequestMapping("/delete/{pid}")
    public String deleteProduct(@PathVariable("pid") Integer pid) {
        productService.removeProduct(pid);
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{pid}")
    public String editProduct(@PathVariable("pid") Integer pid, Map<String, Object> map) {
        map.put("product", productService.getProductById(pid));
        map.put("productList", productService.listProduct());
        return "index";
    }
}
