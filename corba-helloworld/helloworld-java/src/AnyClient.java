import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;

import HelloWorld.Hello;
import HelloWorld.HelloHelper;


public class AnyClient {
	public static void main(String [] args) {
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
			
			Object cobj = orb.string_to_object(ior);
			
			
			
			System.out.println("cobj=" + cobj);
			System.out.println("idef=" + idef);
		}
		catch(Exception ex) {
			ex.printStackTrace(System.err);
			System.exit(1);
		}
	}
}
