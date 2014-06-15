import HelloWorld.HelloPOA;


public class HelloImpl extends HelloPOA {
	@Override
	public String world(String name) {
		
		System.out.println("HelloImpl::world() called");
		
		return "Hello " + name + " !";
	}
}
