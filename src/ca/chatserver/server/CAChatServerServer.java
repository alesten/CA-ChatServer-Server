/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.chatserver.server;

import ca.entity.Client;
import controller.ClientController;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Utils;

/**
 *
 * @author AlexanderSteen
 */
public class CAChatServerServer {

    private static final Properties properties = Utils.initProperties("Server.properties");
    private static ClientController cc = new ClientController();
    private static boolean running = true;
    private static ServerSocket ss;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String logFile = properties.getProperty("logFile");
        Utils.setLogFile(logFile, CAChatServerServer.class.getName());

        new CAChatServerServer().runServer();
        
        Utils.closeLogger(CAChatServerServer.class.getName());
    }

    private void runServer() {
        new ChatServerThread().start();

        String ip = properties.getProperty("serverIp");
        int port = Integer.parseInt(properties.getProperty("port"));

        Logger.getLogger(CAChatServerServer.class.getName()).log(Level.INFO, "Sever started. Listening on: " + port + ", bound to: " + ip);
        try {
            ss = new ServerSocket();
            ss.bind(new InetSocketAddress(ip, port));
            do {
                Socket socket = ss.accept(); //Important Blocking call
                Logger.getLogger(CAChatServerServer.class.getName()).log(Level.INFO, "Connected to a client");
                Client client = new Client(socket, cc);
                client.start();
            } while (running);
        } catch (IOException ex) {
            Logger.getLogger(CAChatServerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void stopSever() {
        CAChatServerServer.running = false;
    }
}
