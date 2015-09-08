/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.entity;

import java.net.Socket;

/**
 *
 * @author RolfMoikjær
 */
public class Client {

    String userName;
    Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

}
