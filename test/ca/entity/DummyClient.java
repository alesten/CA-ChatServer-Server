/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.entity;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author RolfMoikjær
 */
public class DummyClient {

    Socket socket;
    private Scanner input;
    private PrintWriter output;
    private String userName;

    public DummyClient() throws IOException {
        socket = new Socket("localhost", 8888);
        input = new Scanner(socket.getInputStream());
        output = new PrintWriter(socket.getOutputStream(), true);
    }

    public void send(String msg) {
        output.println(msg);
    }

    public String receive() {
        String msg = input.nextLine();
        System.out.println(msg);
        return msg;
    }
}
