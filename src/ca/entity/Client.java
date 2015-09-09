/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.entity;

import ca.protocol.Protocol;
import controller.ClientController;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void send(String msg, String sender) {
        output.println(Protocol.MSG + sender + "#" + msg);
    }

    public void send(String msg) {
        output.println(msg);
    }

    @Override
    public void run() {
        String inputStr;

        while (true) {
            inputStr = input.nextLine();

            if (inputStr.contains(Protocol.USER)) {
                String name = inputStr.substring(Protocol.USER.length());

                if (userName != null && !userName.isEmpty()) {
                    send("You are already connected with UserName " + userName, "System");
                    continue;
                }

                userName = name;
                if (cc.AddClient(this)) {
                    send("Connected with UserName " + userName, "System");
                } else {
                    send("UserName already in use", "System");
                }
            } else if (inputStr.contains(Protocol.MSG)) {
                if (userName == null) {
                    send("You need to connect first using USER#{UserName}", "System");
                    continue;
                }

                String str = inputStr.substring(Protocol.MSG.length());

                if (!str.contains("#")) {
                    send("Command not found", "System");
                    continue;
                }

                String receviversStr = str.split("[#]")[0];
                String message = str.split("[#]")[1];

                if (receviversStr.equals("*")) {
                    cc.SendToAll(message, userName);
                    continue;
                }

                if (receviversStr.contains(",")) {
                    String[] recevivers = receviversStr.toLowerCase().split("[,]");
                    cc.SendToUsers(recevivers, message, userName);
                    continue;
                }

                if (!cc.SendToUser(receviversStr, message, userName)) {
                    send("Could not find user " + receviversStr, "System");
                }
            } else if (inputStr.contains(Protocol.STOP)) {
                send("Disconnted", "System");
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                cc.RemoveClient(this);
                break;
            } else {
                send("Command not found", "System");
            }
        }
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
        if (!Objects.equals(this.userName.toLowerCase(), other.userName.toLowerCase())) {
            return false;
        }
        return true;
    }

    public String getUserName() {
        return userName;
    }

}
