package client;

import util.NetworkUtil;

import java.util.Scanner;

public class WriteThread implements Runnable {
	
	private Thread thr;
	private NetworkUtil nc;
	String name;
    Main main;

	public WriteThread(NetworkUtil nc,Main main,String name) {
		this.nc = nc;
		this.name=name;
        this.main=main;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			//Scanner input=new Scanner(System.in);
			while(true) {
				//String s=input.nextLine();
                if(main.c){
                    nc.write(name);
                    main.c=false;
                }

			}
		} catch(Exception e) {
			System.out.println (e);
		}			
		nc.closeConnection();
	}
}



