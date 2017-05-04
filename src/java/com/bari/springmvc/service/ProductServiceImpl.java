
package com.bari.springmvc.service;

import com.bari.springmvc.dao.ProductDao;
import com.bari.springmvc.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;
    
    
    @Override
    @Transactional
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    @Transactional
    public List<Product> listProduct() {
        return productDao.listProduct();
    }

    @Override
    @Transactional
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    @Transactional
    public void removeProduct(Integer productId) {
        productDao.removeProduct(productId);
    }
    
}
