/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;

/**
 *
 * @author kirbymckenzie
 */
public interface ProductDAO {
   
   void saveProduct(Product aProduct);
   
   void deleteProduct(Product aProduct);
   
   Collection<Product> getAll();
   
   Collection <Product> getByCategory(String category);
   
   Collection<String> getCategories();
   
   Product getById(Integer id);
  
   
}
