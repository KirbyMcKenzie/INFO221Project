/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author kirbymckenzie
 */
@RunWith(Parameterized.class)
public class DAOTests {

    private final ProductDAO dao; //= new ProductJdbcDAO("jdbc:h2:tcp://localhost/~/project-testing");

    // first test product
    private Product prodOne;

    // second test product
    private Product prodTwo;

    public DAOTests(ProductDAO dao) {
        this.dao = dao;
    }

    @Parameterized.Parameters
    public static Collection<?> daoObjectsToTest() {
        return Arrays.asList(new Object[][]{
            {new ProductCollectionsDAO()},
            {new ProductJdbcDAO(
                "jdbc:h2:tcp://localhost/~/project-testing")}
        });
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        // first test product
        this.prodOne = new Product(1, "name1", "cat1", "desc1", 11.0, 22);
        // second test product
        this.prodTwo = new Product(2, "name2", "cat2", "desc2", 33.0, 44);

        // save the products
        dao.saveProduct(prodOne);
        dao.saveProduct(prodTwo);

    }

    @After
    public void tearDown() {

        dao.deleteProduct(prodOne);
        dao.deleteProduct(prodTwo);

    }

    @Test
    public void testDaoSaveAndDelete() {
// create product for testing
        Product savedProd = new Product(333, "name3", "cat3", "desc3", 1.0, 2);

// save the product using DAO
        dao.saveProduct(savedProd);

// retrieve the same product via DAO
        Product retrieved = dao.getById(333);

// ensure that the product we saved is the one we got back
        assertEquals("Retrieved product should be the same as the saved one",
                savedProd, retrieved);

// delete the product via the DAO
        dao.deleteProduct(savedProd);

// try to retrieve the deleted product
        retrieved = dao.getById(333);

// ensure that the product was not retrieved (should be null)
        assertNull("Product should no longer exist", retrieved);

    }

    @Test
    public void testDaoGetAll() {

// call getAll
        Collection<Product> products = dao.getAll();

// ensure the result includes the test products
        assertTrue("prodOne should exist", products.contains(prodOne));
        assertTrue("prodTwo should exist", products.contains(prodTwo));

// ensure the result ONLY includes the test products
        assertEquals("Only 2 products in result", 2, products.size());

// nd prodOne − result is generic collection, so we have to sequentially search for it
        for (Product p : products) {

            if (p.equals(prodOne)) {

// ensure that all of the details were correctly retrieved
                assertEquals(prodOne.getProductID(), p.getProductID());
                assertEquals(prodOne.getName(), p.getName());
                assertEquals(prodOne.getDescription(), p.getDescription());
                assertEquals(prodOne.getCategory(), p.getCategory());
                assertEquals(prodOne.getPrice(), p.getPrice());
                assertEquals(prodOne.getQuantity(), p.getQuantity());
            }
        }
    }

    @Test
    public void testDaoFindById() {

// get prodOne using findById method
        Product retrieved = dao.getById(prodOne.getProductID());

// ensure that you got back prodOne, and not another product
        assertEquals("Ensure prodOne is retrieved", prodOne, retrieved);
// ensure that prodOne's details were properly retrieved
        assertEquals(prodOne.getProductID(), retrieved.getProductID());
        assertEquals(prodOne.getName(), retrieved.getName());
        assertEquals(prodOne.getDescription(), retrieved.getDescription());
        assertEquals(prodOne.getCategory(), retrieved.getCategory());
        assertEquals(prodOne.getPrice(), retrieved.getPrice());
        assertEquals(prodOne.getQuantity(), retrieved.getQuantity());

// call findById using a non−existent ID
        retrieved = dao.getById(99);
// ensure that the result is null
        assertNull("Product should no longer exist", retrieved);
    }
}
