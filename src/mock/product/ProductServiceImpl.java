/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock.product;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdjukanovic
 */
public class ProductServiceImpl implements ProductService{

    private static ProductServiceImpl instance;
    
    private ProductServiceImpl(){
        
    }
    
    public static ProductService getInstance(){
        if(instance == null){
            instance = new ProductServiceImpl();
        }
        return instance;
    }
    
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
       
        products.add(new Product("Voda",150));
        products.add(new Product("Naocare za sunce", 20000));
        products.add(new Product("Sat", 100000));
        products.add(new Product("Sto", 30000));
      
        return products;
    }
    
    
    
}
