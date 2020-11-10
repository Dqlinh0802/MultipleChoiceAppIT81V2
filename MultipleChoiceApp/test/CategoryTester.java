
import com.mysql.jdbc.Connection;
import com.tbn.pojo.Category;
import com.tbn.services.CategoryServices;
import com.tbn.services.Utils;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class CategoryTester {
    
    private static Connection conn;
    
    @BeforeClass
    public static void setUp(){
        conn = (Connection) Utils.getConn();
    }
    
    @AfterClass
    public static void tearDown(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testNameIsNotNull(){
        try {
            List<Category> cats = CategoryServices.getCategories();
            for(Category cat: cats){
                Assert.assertNotNull(cat.getName());
                Assert.assertNotEquals("", cat.getName().trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testCateCounter(){
        try {
            List<Category> cats = CategoryServices.getCategories();
            Assert.assertTrue(cats.size() >=5);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
