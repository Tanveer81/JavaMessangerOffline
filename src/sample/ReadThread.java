package sample;

import javafx.beans.property.SimpleStringProperty;
import util.NetworkUtil;

import java.util.Hashtable;

public class ReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;
    Main main;
    public Hashtable<String, NetworkUtil> table;

	public ReadThread(NetworkUtil nc,Main main,Hashtable<String, NetworkUtil>table) {
		this.nc = nc;
        this.main=main;
        this.table=table;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			while(true) {
				String s=(String)nc.read();
                table.put(s,nc);
                Person person=new Person(new SimpleStringProperty(s),nc,main);
                main.persons.add(person);
				System.out.println(s);
			}
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
	}
}



