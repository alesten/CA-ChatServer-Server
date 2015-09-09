/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ca.entity.Client;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Utils;

/**
 *
 * @author RolfMoikjær
 */
public class ClientControllerTest {

    private static final Properties properties = Utils.initProperties("Server.properties");
    private static ClientController cc = new ClientController();
    private static Client client;
    static ServerSocket ss;

    public ClientControllerTest() {
    }

    /**
     * Test of AddClient method, of class ClientController.
     */
    @Test
    public void testAddClient() throws IOException {
        String ip = properties.getProperty("serverIp");
        int port = Integer.parseInt(properties.getProperty("port"));
        boolean expResult = true;
        boolean result;

        ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, port));
        client = new Client(ss.accept(), cc);
        client.start();
        result = cc.AddClient(client);
        client.interrupt();

        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of RemoveClient method, of class ClientController.
//     */
//    @Test
//    public void testRemoveClient() {
//        System.out.println("RemoveClient");
//        Client client = null;
//        ClientController instance = new ClientController();
//        instance.RemoveClient(client);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of SendToAll method, of class ClientController.
//     */
//    @Test
//    public void testSendToAll_String_String() {
//        System.out.println("SendToAll");
//        String msg = "";
//        String sender = "";
//        ClientController instance = new ClientController();
//        instance.SendToAll(msg, sender);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of SendToAll method, of class ClientController.
//     */
//    @Test
//    public void testSendToAll_String() {
//        System.out.println("SendToAll");
//        String msg = "";
//        ClientController instance = new ClientController();
//        instance.SendToAll(msg);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of SendToUser method, of class ClientController.
//     */
//    @Test
//    public void testSendToUser() {
//        System.out.println("SendToUser");
//        String user = "";
//        String msg = "";
//        String sender = "";
//        ClientController instance = new ClientController();
//        boolean expResult = false;
//        boolean result = instance.SendToUser(user, msg, sender);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of SendToUsers method, of class ClientController.
//     */
//    @Test
//    public void testSendToUsers() {
//        System.out.println("SendToUsers");
//        String[] users = null;
//        String msg = "";
//        String sender = "";
//        ClientController instance = new ClientController();
//        instance.SendToUsers(users, msg, sender);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of SendUserList method, of class ClientController.
//     */
//    @Test
//    public void testSendUserList() {
//        System.out.println("SendUserList");
//        ClientController instance = new ClientController();
//        instance.SendUserList();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
