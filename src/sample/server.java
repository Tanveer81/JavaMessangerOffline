package sample;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

import util.NetworkUtil;

public class server implements Runnable {
    private ServerSocket ServSock;
    public int i = 1;
    public Hashtable<String, NetworkUtil> table;
    Main main;
    server(Main main) {this.main=main;}
    @Override
    public void run(){
        table = new Hashtable<>();
        try {
            ServSock = new ServerSocket(33333);
            new WriteThreadServer(table, "Server",main);
            while (true) {
                Socket clientSock = ServSock.accept();
                NetworkUtil nc=new NetworkUtil(clientSock);
                //Person person=new Person("c"+i++);
                table.put("c"+i++, nc);
                new ReadThread(nc,main,table);


            }
        }catch(Exception e) {
            System.out.println("Server starts:"+e);
        }
    }

}






/*import util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class server implements Runnable {
    private ServerSocket ServSock;
    public int i = 1;
    public Hashtable<String, NetworkUtil> table;
    Main main;
    server(Main main) {this.main=main;}
    @Override
    public void run(){
        table = new Hashtable<>();
        try {
            ServSock = new ServerSocket(33333);
            new WriteThreadServer(table, "Server",main);
            while(true){
                Socket clientSock = ServSock.accept();
                NetworkUtil nc=new NetworkUtil(clientSock);
               // table.put("c"+ i++, nc);
                new ReadThread(nc,main,table);
            }
        }catch(Exception e) {
            System.out.println("Server starts:"+e);
        }
    }



}*/
