import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;


public class Server {

	public static void main(String [] args) {
		
		try {
			ORB orb = ORB.init(args, null);
		
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			
			rootPOA.the_POAManager().activate();
			
			HelloImpl helloImpl = new HelloImpl();
			
			rootPOA.activate_object(helloImpl);
			
			System.out.println(orb.object_to_string(helloImpl._this_object()));
			
			System.out.println("Starting ORB");
			
			orb.run();
			
			System.out.println("Done");
		}
		catch(Exception ex) {
			ex.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
}
