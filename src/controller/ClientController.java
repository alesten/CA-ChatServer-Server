package controller;

import ca.entity.Client;
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
        return true;
    }

    public void RemoveClient(Client client) {
        clients.remove(client);
    }

    public void SendToAll(String msg) {
        for (Client client : clients) {
            client.send(msg);
        }
    }

    public boolean SendToUser(String user, String msg) {
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
        endClient.send(msg);
        return true;
    }

    public void SendToUsers(String[] users, String msg) {

        for (Client client : clients) {
            if (Arrays.asList(users).contains(client.getUserName().toLowerCase())) {
                client.send(msg);
            }
        }

    }
}
