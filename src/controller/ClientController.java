package controller;

import ca.entity.Client;
import ca.protocol.Protocol;
import java.util.ArrayList;
import java.util.Arrays;

public class ClientController {

    private ArrayList<Client> clients;

    public ClientController() {
        clients = new ArrayList();
    }

    public boolean AddClient(Client client) {
        if (clients.contains(client)) {
            return false;
        }
        clients.add(client);
        SendUserList();
        return true;
    }

    public void RemoveClient(Client client) {
        clients.remove(client);
        SendUserList();
    }

    public void SendToAll(String msg, String sender) {
        for (Client client : clients) {
            client.send(msg, sender);
        }
    }

    public void SendToAll(String msg) {
        for (Client client : clients) {
            client.send(msg);
        }
    }

    public boolean SendToUser(String user, String msg, String sender) {
        Client endClient = null;
        for (Client client : clients) {
            if (client.getUserName().toLowerCase().equals(user.toLowerCase())) {
                endClient = client;
                break;
            }
        }

        if (endClient == null) {
            return false;
        }
        endClient.send(msg, sender);
        return true;
    }

    public void SendToUsers(String[] users, String msg, String sender) {

        for (Client client : clients) {
            if (Arrays.asList(users).contains(client.getUserName().toLowerCase())) {
                client.send(msg, sender);
            }
        }

    }

    public void SendUserList() {
        String userList = Protocol.USERLIST;
        for (Client client : clients) {
            userList += client.getUserName() + ",";
        }
        if (clients.size() > 0) {
            userList = userList.substring(0, userList.length() - 1);
        }
        SendToAll(userList);
    }
}
