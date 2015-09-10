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
    DummyClient dummyClient;

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
        dummyClient = new DummyClient();
        
        //First Test USER#
        System.out.println("USER#");
        String msg1 = "USER#Rolf";
        String receive1 = "USERLIST#Rolf";
        
        dummyClient.send(msg1);

        assertEquals(dummyClient.receive(), receive1);

        //next test MSG#
        System.out.println("MSG#");
        String msg2 = "MSG#*#HEJHEJ";
        String receive2 = "MSG#Rolf#HEJHEJ";

        dummyClient.send(msg2);

        assertEquals(dummyClient.receive(), receive2);
    }

}
