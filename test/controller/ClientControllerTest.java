/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ca.entity.Client;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RolfMoikjær
 */
public class ClientControllerTest {
    
    public ClientControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of AddClient method, of class ClientController.
     */
    @org.junit.Test
    public void testAddClient() {
        System.out.println("AddClient");
        Client client = null;
        ClientController instance = new ClientController();
        boolean expResult = false;
        boolean result = instance.AddClient(client);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoveClient method, of class ClientController.
     */
    @org.junit.Test
    public void testRemoveClient() {
        System.out.println("RemoveClient");
        Client client = null;
        ClientController instance = new ClientController();
        instance.RemoveClient(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SendToAll method, of class ClientController.
     */
    @org.junit.Test
    public void testSendToAll() {
        System.out.println("SendToAll");
        String msg = "";
        ClientController instance = new ClientController();
        instance.SendToAll(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SendToUser method, of class ClientController.
     */
    @org.junit.Test
    public void testSendToUser() {
        System.out.println("SendToUser");
        String user = "";
        String msg = "";
        ClientController instance = new ClientController();
        boolean expResult = false;
        boolean result = instance.SendToUser(user, msg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SendToUsers method, of class ClientController.
     */
    @org.junit.Test
    public void testSendToUsers() {
        System.out.println("SendToUsers");
        String[] users = null;
        String msg = "";
        ClientController instance = new ClientController();
        instance.SendToUsers(users, msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
