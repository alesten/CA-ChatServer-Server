/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ca.chatserver.server.CAChatServerServer;
import ca.entity.Client;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
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
    private static ClientController cc;
    private static Client client;
    static ServerSocket ss;

    @BeforeClass
    public static void setUpClass() throws IOException {
        CAChatServerServer.main(null);
        String ip = properties.getProperty("serverIp");
        int port = Integer.parseInt(properties.getProperty("port"));
        cc = new ClientController();
        ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, port));
        client = new Client(ss.accept(), cc);
        client.start();
    }

    @AfterClass
    public static void tearDownClass() {
        client.interrupt();
    }

    /**
     * Test of AddClient method, of class ClientController.
     */
    @Test
    public void testAddClient() {
        boolean expResult = true;
        boolean result;
        result = cc.AddClient(client);

        assertEquals(expResult, result);

    }

}
