package controller;

import ca.entity.Client;
import java.util.ArrayList;

public class ClientController {
    private ArrayList<Client> clients;

    public ClientController() {
        clients = new ArrayList();
    }
    
    public boolean AddClient(Client client){
        if(clients.contains(client)){
            return false;
        }
        clients.add(client);
        return true;
    }
    
    public void RemoveClient(Client client){
        clients.remove(client);
    }
}
