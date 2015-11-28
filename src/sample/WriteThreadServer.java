package sample;

import util.NetworkUtil;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WriteThreadServer implements Runnable {

    private Thread thr;
    Main main;
    String name;
    NetworkUtil nc;
    public Hashtable<String, NetworkUtil> table;
    String s;

    public WriteThreadServer(Hashtable<String, NetworkUtil>table, String name,Main main) {
        this.name=name;
        this.table=table;
        this.main=main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while(true) {
                s=main.c.textArea.getText();
                if (main.b){
                   String cName=main.person.getFirstName();
                    nc = table.get(cName);

                        nc.write(name + ":" + s);
                        System.out.println(s);
                        main.b=false;
                    }
                }
           // }

        } catch(Exception e) {
           System.out.println (e);
        }
    }
}
