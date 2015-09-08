/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.chatserver.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Properties;
import utils.Utils;

/**
 *
 * @author AlexanderSteen
 */
public class CAChatServerServer {

    private static final Properties properties = Utils.initProperties("Server.properties");

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String ip = properties.getProperty("serverIp");
        int port = Integer.parseInt(properties.getProperty("port"));
        if(args.length == 2){
            ip = args[0];
            port = Integer.parseInt(args[1]);
        }
        
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, port));
    }
}
