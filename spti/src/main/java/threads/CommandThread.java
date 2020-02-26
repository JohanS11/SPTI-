package threads;

import java.io.IOException;

public class CommandThread extends Thread{
	
	private String comando;
	public CommandThread(String comando) {
		this.comando = comando;
	}
	
	
	@Override
	public void run() {
		
		try {
			Runtime.getRuntime().exec(comando);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
