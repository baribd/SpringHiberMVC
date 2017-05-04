
package com.bari.springmvc.dao;

import com.bari.springmvc.model.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements 
         ProductDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void updateProduct(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public List<Product> listProduct() {
       return  sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public Product getProductById(Integer productId) {
        Session session = sessionFactory.getCurrentSession();
        List<Product> list = session.createQuery("from Product p where p.id=:productid").setParameter("productid", productId).list();
        return list.size()>0?(Product)list.get(0):null;
        
    }

    @Override
    public void removeProduct(Integer productId) {
        Product product = (Product)sessionFactory.getCurrentSession().load(Product.class, productId);
        if(product!=null){
        sessionFactory.getCurrentSession().delete(product);
        }
    }
    
}
