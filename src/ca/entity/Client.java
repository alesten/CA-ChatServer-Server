/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.entity;

import controller.ClientController;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author RolfMoikjær
 */
public class Client extends Thread {

    private String userName;
    private Socket socket;
    private PrintWriter output;
    private Scanner input;
    private ClientController cc;

    public Client(Socket socket, ClientController cc) throws IOException {
        this.socket = socket;
        this.cc = cc;
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new Scanner(socket.getInputStream());

    }

    public void run() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }

}
