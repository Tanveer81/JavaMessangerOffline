package client;

import util.NetworkUtil;

import java.util.Hashtable;

public class ReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;
    Main main;
	public ReadThread(NetworkUtil nc,Main main) {
		this.nc = nc;
        this.main=main;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			while(true) {
				String s=(String)nc.read();
                main.a.output.setText(s);
				System.out.println(s);
			}
		} catch(Exception e) {
			System.out.println (e);
		}
		nc.closeConnection();
	}
}



