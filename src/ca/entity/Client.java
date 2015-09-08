/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.entity;

import java.net.Socket;
import java.util.Objects;

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
