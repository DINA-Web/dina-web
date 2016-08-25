/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.logic.util;
    
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; 
import java.util.Map;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;  
import org.junit.BeforeClass;
import org.junit.Test;
import static org.testng.Assert.fail;
import se.nrm.dina.data.exceptions.DinaException;
import se.nrm.dina.datamodel.BaseEntity;
import se.nrm.dina.datamodel.impl.Testentity;
/**
 *
 * @author idali
 */
public class NamedQueriesNGTest {
    
    private NamedQueries instance;
    
    public NamedQueriesNGTest() {
    }


    @BeforeClass
    public static void setUpClass() throws Exception { 
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
 
    
    @Test
    public void testGetInstanceNull() {
        System.out.println("getInstance"); 
        
        instance = null;
        instance = NamedQueries.getInstance();
        assertNotNull(instance);
    }
 
    /**
     * Test of getInstance method, of class NamedQueries.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance"); 
        instance = NamedQueries.getInstance();
        assertNotNull(instance);
    }
    
    
    
    /**
     * Test of createQueryFindAll method, of class NamedQueries.
     */
    @Test
    public void testCreateQueryFindAll() {
        System.out.println("createQueryFindAll");
        
        String entityName = "Testentity";
        Class clazz = Testentity.class;
         
        String sort = "asc";
        List<String> orderBy = new ArrayList<>();
        orderBy.add("version");
        
        instance = new NamedQueries();
        String expResult = "SELECT e From Testentity e  ORDER BY e.version asc";
        String result = instance.createQueryFindAll(entityName, clazz, sort, orderBy);
        assertEquals(result, expResult); 
    }
    
    
    /**
     * Test of createQueryFindAll method, of class NamedQueries.
     */
    @Test
    public void testCreateQueryFindAllNoOrderBy() {
        System.out.println("createQueryFindAll");
        
        String entityName = "Testentity";
        Class clazz = Testentity.class;
         
        String sort = "asc";
        List<String> orderBy = null;
       
        
        instance = new NamedQueries();
        String expResult = "SELECT e From Testentity e  ORDER BY e.id asc";
        String result = instance.createQueryFindAll(entityName, clazz, sort, orderBy);
        assertEquals(result, expResult); 
    }
    
    @Test(expected = DinaException.class)
    public void testCreateQueryFindAllException() {
        System.out.println("createQueryFindAll");
        
        String entityName = "BaseEntity";
        Class clazz = BaseEntity.class;
          
        instance = new NamedQueries(); 
        instance.createQueryFindAll(entityName, clazz, "asc", null); 
        
    }

     

    /**
     * Test of createQueryFindAllWithSearchCriteria method, of class NamedQueries.
     */
    @Test
    public void testCreateQueryFindAllWithSearchCriteria() {
        System.out.println("createQueryFindAllWithSearchCriteria");
        
        String entityName = "Testentity";
        Class clazz = Testentity.class;
        String sort = "asc";
        List<String> orderBy = null;
        boolean isExact = false;
        
        Map<String, String> criteria = null;
        instance = new NamedQueries();
        String expResult = "SELECT e From Testentity e  ORDER BY e.id asc";
        String result = instance.createQueryFindAllWithSearchCriteria(entityName, clazz, sort, orderBy, isExact, criteria);
        assertEquals(result, expResult); 
    }

    
    @Test
    public void testCreateQueryFindAllWithSearchCriteria1() {
        System.out.println("createQueryFindAllWithSearchCriteria");
        
        String entityName = "Testentity";
        Class clazz = Testentity.class;
        String sort = "asc";
        List<String> orderBy = new ArrayList<>();
        orderBy.add("version");
        
        boolean isExact = true;
        
        Map<String, String> criteria = new HashMap<>();
        criteria.put("version", "1");
        criteria.put("s", "2");
        
        
        instance = new NamedQueries();
        String expResult = "SELECT e From Testentity e  WHERE  e.s = :s AND  e.version = :version ORDER BY e.version asc";
        String result = instance.createQueryFindAllWithSearchCriteria(entityName, clazz, sort, orderBy, isExact, criteria);
        assertEquals(result, expResult); 
    }
    
    @Test(expected = DinaException.class)
    public void testCreateQueryFindAllWithSearchCriteriaException() {
        System.out.println("createQueryFindAllWithSearchCriteria");
        
        String entityName = "BaseEntity";
        Class clazz = BaseEntity.class;
        String sort = "asc";
        List<String> orderBy = new ArrayList<>();
        orderBy.add("version");
        
        boolean isExact = true;
        
        Map<String, String> criteria = new HashMap<>();
        criteria.put("version", "1");
        criteria.put("s", "2");
         
        instance = new NamedQueries(); 
        instance.createQueryFindAllWithSearchCriteria(entityName, clazz, sort, orderBy, isExact, criteria); 
    }
    
    
    /**
     * Test of createFindTotalCountNamedQuery method, of class NamedQueries.
     */
    @Test
    public void testCreateFindTotalCountNamedQuery() {
        System.out.println("createFindTotalCountNamedQuery");
        
        String entityName = "Testentity";
        
        instance = new NamedQueries();
        String expResult = "SELECT COUNT(e) FROM Testentity e";
        String result = instance.createFindTotalCountNamedQuery(entityName);
        assertEquals(result, expResult); 
    } 
    
}
