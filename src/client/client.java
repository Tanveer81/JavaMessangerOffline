package client;

import util.NetworkUtil;

public class client implements Runnable {
        Main main;
        String name;
        client(Main main,String name){
            this.main=main;
            this.name=name;
        }

        @Override
        public void run(){
        try {
            String serverAddress = "127.0.0.1";
            int serverPort = 33333;
            NetworkUtil nc = new NetworkUtil(serverAddress,serverPort);
            new ReadThread(nc,main);
            new WriteThread(nc,main,name);
        } catch(Exception e) {
            System.out.println (e);
        }
    }



}
