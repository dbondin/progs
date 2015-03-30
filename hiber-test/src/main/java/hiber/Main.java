package hiber;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entities.Breed;
import entities.Cat;
import entities.Dog;
import entities.Human;
import entities.Pet;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);
	
	@SuppressWarnings("unused")
	private static void addCat(SessionFactory sf, String name, int age) {
		Session s = sf.getCurrentSession();
		Cat cat = new Cat();
		cat.setName(name);
		cat.setAge(age);
		
		s.beginTransaction();
		s.save(cat);
		s.getTransaction().commit();
	}
	
	@SuppressWarnings("unused")
	private static void findCats(SessionFactory sf, int minAge) {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("from Cat where age >= ?");
		q.setInteger(0, minAge);
		@SuppressWarnings("unchecked")
		List<Cat> cats = q.list();
		for(Cat c : cats) {
			log.debug("CAT: " + c.getId() + "; " + c.getName() + "; " + c.getAge()); 
		}
		s.getTransaction().commit();
	}
	
	@SuppressWarnings("unused")
	private static void findCats(SessionFactory sf) {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Cat> cats = s.createQuery("from Cat").list();
		for(Cat c : cats) {
			log.debug("CAT: " + c.getId() + "; " + c.getName() + "; " + c.getAge()); 
		}
		s.getTransaction().commit();
	}
	
	@SuppressWarnings("unused")
	private static void deleteCat(SessionFactory sf, Long id) {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Cat c = (Cat) s.get(Cat.class, id);
		s.delete(c);
		s.getTransaction().commit();
	}
	
	@SuppressWarnings("unused")
	private static void updateCat(SessionFactory sf, Long id) {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Cat c = (Cat) s.get(Cat.class, id);
		c.setAge(c.getAge() + 1);
		s.saveOrUpdate(c);
		s.getTransaction().commit();
	}
	
	public static void main(String[] args) throws Throwable {
		Configuration conf = new Configuration();
		conf.configure();
		StandardServiceRegistry srvreg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(srvreg);

		//addCat(sf, "Васька", 4);
		//addCat(sf, "Мурка", 3);
		//addCat(sf, "Пушок", 5);
		
		//findCats(sf);
		
		//deleteCat(sf, 4L);
		//updateCat(sf, 5L);
		
		//findCats(sf);
		
		//findCats(sf, 4);
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Breed b = new Breed();
		b.setName("Перс");
		b.setDescr("Красивый кот");
		s.save(b);
		
		Cat c = new Cat();
		c.setName("Васька");
		c.setAge(3);
		c.setBreed(b);
		c.setVolume(0.0);
		s.save(c);
		
		c = new Cat();
		c.setName("Мурка");
		c.setAge(5);
		c.setBreed(b);
		c.setVolume(1.0);
		s.save(c);
		
		c = new Cat();
		c.setName("Пушок");
		c.setAge(2);
		s.save(c);
		
		s.getTransaction().commit();
		
		s = sf.getCurrentSession();
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Cat> cats = s.createQuery("from Cat").list();
		s.getTransaction().commit();
		for(Cat cat : cats) {
			log.info("CAT: " + cat.getId() + " " + cat.getName() + " "  + cat.getAge() + " " + ((cat.getBreed() == null) ? "-" : cat.getBreed().getName()));
		}
		//s.getTransaction().commit();
		
		s = sf.getCurrentSession();
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Breed> breeds = s.createQuery("from Breed").list();
		for(Breed breed : breeds) {
			log.info("BREED: " + breed.getId() + " " + breed.getName());
			for(Pet cat : breed.getPets()) {
				log.info("  CAT: " + cat.getId() + " " + cat.getName() + " "  + cat.getAge());
			}
		}
		s.getTransaction().commit();
		
		s = sf.getCurrentSession();
		s.beginTransaction();
		cats = s.createQuery("from Cat").list();
		Human h = new Human();
		h.setName("Иванов Иван Иванович");
		h.setDob(new SimpleDateFormat("DD-mm-yyyy").parse("23-06-1979"));
		h.getPets().addAll(cats);
		s.save(h);
		h = new Human();
		h.setName("Джон Смитт");
		h.setDob(new SimpleDateFormat("DD-mm-yyyy").parse("01-01-1970"));
		h.getPets().addAll(cats);
		s.save(h);
		s.getTransaction().commit();
		
		
		s = sf.getCurrentSession();
		s.beginTransaction();
		b = new Breed();
		b.setName("Немецкая овчарка");
		s.save(b);
		Dog d = new Dog();
		d.setName("Рекс");
		d.setAge(6);
		d.setBreed(b);
		d.setTrained(true);
		h = (Human) s.createQuery("from Human where name like 'Иванов%'").uniqueResult();
		d.getHumans().add(h);
		s.save(d);
		s.getTransaction().commit();
		
		s = sf.getCurrentSession();
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Pet> pets = s.createQuery("from Pet").list();
		for(Pet pet : pets) {
			log.info("PET: " + pet.getId() + " " + pet.getName() + " " + pet.getAge() + " // " + pet.getClass());
			if(pet instanceof Cat) {
				c = (Cat) pet;
				log.info("  CAT: " + c.getVolume());
			}
			if(pet instanceof Dog) {
				d = (Dog) pet;
				log.info("  DOG: " + d.getTrained());
			}
		}
		s.getTransaction().commit();
		
		log.info("Done");
		
		System.exit(0);
	}
}
