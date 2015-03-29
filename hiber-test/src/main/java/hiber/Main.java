package hiber;

import javax.imageio.spi.ServiceRegistry;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entities.Cat;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);
	
	private static void addCat(Session s) {
		Cat cat = new Cat();
		cat.setId(1L);
		cat.setName("Васька");
		cat.setAge(3);
		
		s.beginTransaction();
		s.save(cat);
		s.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure();
		StandardServiceRegistry srvreg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(srvreg);

		Session s = sf.getCurrentSession();
		
		addCat(s);
		
		log.info("Done");
		
		System.exit(0);
	}
}
