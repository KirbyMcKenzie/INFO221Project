/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import utilities.MultiMap;

/**
 *
 * @author kirbymckenzie
 */
public class ProductCollectionsDAO implements ProductDAO {

    Product product = new Product();

    // Collection that stores product objects
    private static final Collection<Product> products = new TreeSet<>();

    // Collection that stores the categories from product objects
    private static final Collection<String> categories = new TreeSet<>();

    // Collection that maps product objects by their productIDs 
    private static final Map<Integer, Product> productID = new TreeMap<>();

    // Collection that maps product objects by their Category
    private static final MultiMap<String, Product> productsInCategory = new MultiMap<>();

    @Override
    public void saveProduct(Product aProduct) {

        products.add(aProduct);
        categories.add(aProduct.getCategory());
        productID.put(aProduct.getProductID(), aProduct);
        productsInCategory.put(aProduct.getCategory(), aProduct);

    }

    @Override
    public void deleteProduct(Product aProduct) {

        products.remove(aProduct);
        productsInCategory.remove(aProduct.getCategory(), aProduct);
        productID.remove(aProduct.getProductID());
    }

    @Override
    public Product getById(Integer id) {

        return productID.get(id);
    }

    @Override
    public Collection<Product> getAll() {

        return products;
    }

    @Override
    public Collection<String> getCategories() {
        return categories;
    }
    
    @Override
    public Collection<Product> getByCategory(String category) {

        return productsInCategory.get(category);
    }
    
    
}
