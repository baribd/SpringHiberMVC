package com.bari.springmvc.service;

import com.bari.springmvc.model.Product;
import java.util.List;

public interface ProductService {

    public void addProduct(Product product);

    public void updateProduct(Product product);

    public List<Product> listProduct();

    public Product getProductById(Integer productId);

    public void removeProduct(Integer productId);
}
