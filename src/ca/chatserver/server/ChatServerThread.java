package ca.chatserver.server;

import java.util.Scanner;

public class ChatServerThread extends Thread{
    private Scanner scanner;

    public ChatServerThread() {
        scanner = new Scanner(System.in);
    }
    
    public void run(){
        while(true){
            String msg = scanner.nextLine();
            if("exit".equals(msg))
                CAChatServerServer.stopSever();
        }
    }
    
    
}
