import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.CORBA.ORB;

import HelloWorld.Hello;
import HelloWorld.HelloHelper;


public class Client {

	public static void main(String[] args) {
		try {
			final ORB orb = ORB.init(args, null);
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					orb.run();
				}
			}).start();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter IOR: ");
			
			String ior = br.readLine();
			
			System.out.println("Trying ...");
			
			Hello hello = HelloHelper.narrow(orb.string_to_object(ior));
			
			System.out.println(hello.world("Dima"));
			
		}
		catch(Exception ex) {
			ex.printStackTrace(System.err);
			System.exit(1);
		}
	}

}
