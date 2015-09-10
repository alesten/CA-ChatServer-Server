/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.entity;

import ca.chatserver.server.CAChatServerServer;
import controller.ClientController;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.Utils;
import static org.junit.Assert.*;

/**
 *
 * @author RolfMoikjær
 */
public class ClientTest {

    private static ClientController cc;
    private static Client client;
    static Thread serverThread;

    public ClientTest() {
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
        serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    CAChatServerServer.main(null);
                } catch (IOException ex) {
                    Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        serverThread.start();
    }

    @AfterClass
    public static void tearDownClass() {
        serverThread.interrupt();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of send method, of class Client.
     */
    @Test
    public void testSendMSG() throws IOException {
        System.out.println("USER#");
        String msg = "USER#Rolf";
        String receiveMsg = "USERLIST#Rolf";
        DummyClient dummyClient = new DummyClient();
        dummyClient.send(msg);

        assertEquals(dummyClient.receive(), receiveMsg);
    }

    @Test
    public void testSendUSER() {
        System.out.println("USER#");
        
    }
}
