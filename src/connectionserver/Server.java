/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nico
 */





public class Server {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        ServerSocket sSocket = null;
        
        int porta = 3550;
        
        while(true){
            try {
                sSocket = new ServerSocket(porta);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            Socket connessione;
            System.out.println("In attesa di connessioni....");
            try {
                    Pippo p=new Pippo();
                    Thread count=new Thread(p);
                    count.start();
                    
                    sSocket.setSoTimeout(5000);
                
                
                connessione = sSocket.accept();
                System.out.println("Connessione stabilita");
            }
              catch (SocketTimeoutException e){
                System.out.println("Ho atteso 5s, connessione chiusa");
            } catch (SocketException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            try {
                sSocket.close();
                System.out.println("Connessione chiusa");
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
}
