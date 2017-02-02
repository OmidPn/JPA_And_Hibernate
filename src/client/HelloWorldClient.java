package client;

import entity.Guide;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class HelloWorldClient {

			public static void main(String[] args) {

				EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
				EntityManager em = emf.createEntityManager();
				EntityTransaction txn = em.getTransaction();
				try {
					txn.begin();
					//connect ot the DB
					//transaction.begin();
					// *****************how to use @attribute annotations and entity annotation for composition relationship
        			/* how to use @attribute annotations and entity annotation for composition relationship
        			Address homeAddress=new Address("200 E Main St", "Seattle", "85123");
        			Address billAddress=new Address("1090 Qdkfj E Main St", "Monteral", "hfdfk44");
        			Person person = new Person("Ruby", homeAddress,billAddress);
                    */
					// ****** using @ManyToOne annotation in classes to generate foreign keys in DB
					// persisting Student object
        					/*Guide guide = new Guide("dfdfdfd", "Idfdb", 20200);
        					Student student = new Student("2014AL50456", "rtrtr Gill", guide);

                            //using JPA to persist the object and associated object to the related DB
        					session.persist(student);*/

					// ***********deleting Student object

        				/*Student student = (Student) session.get(Student.class,7L);
        				session.delete(student);*/
					// *********** using OneToOne relationship ********

                  /*  Passport passport = new Passport("925076473");
                    Customer customer = new Customer("Nicole Scott", passport);
                    session.persist(customer);*/

					//******* ManyToMany relationship JointTable annotaiton and ManyToMany annotation
        /*

        			Movie movie1=new Movie("Inception");
        			Movie movie2=new Movie("Catch Me If You Can");
        			Actor actor1=new Actor("Leonardo Decaprio");
        			Actor actor2=new Actor("Cristrian Bale");

        			movie1.getActorSet().add(actor1);
        			movie2.getActorSet().add(actor1);
        			movie2.getActorSet().add(actor2);

        			session.persist(movie1);
        			session.persist(movie2);
        */

					// Updating the inverse end (Actor)
        /*
        		        	Movie movie = (Movie) session.get(Movie.class, 1L);
        		        	Actor actor = (Actor) session.get(Actor.class, 2L);
        		        	actor.getMovieSet().add(movie);
        */
					// Updating the owner (Movie)
          			/*
                	Movie movie = (Movie) session.get(Movie.class, 1L);
                	Actor actor = (Actor) session.get(Actor.class, 2L);
                	movie.getActors().add(actor);
                	*/


					// Updating the owner (Movie) delete
        		        	/*Movie movie = (Movie) session.get(Movie.class, 2L);
        		        	Actor actor = (Actor) session.get(Actor.class, 2L);
        		        	movie.getActorSet().remove(actor);*/



				/*	// Using JPA instead of Hibernate to manage session by using --> entity manager


					Message message = new Message("Hello "); //transient state
					em.persist(message); //persistent state

					txn.commit();
					em.close();
					em=null;

					message.setText("Modify the detached message"); //modifying the detached state of message

					EntityManager em2 = emf.createEntityManager();
					EntityTransaction txn2 = em2.getTransaction();
					txn2.begin();

					//the returned mergedMessage is a persistent object
					//any changes to mergedMessage will be dirty checked when the txn2 will be committed and updated in the database
					Message mergedMessage = em2.merge(message);

					txn2.commit();
					em2.close();
*/

					//Detaching objects explicitly
		/*
		EntityManager em3 = emf.createEntityManager();
		EntityTransaction txn3 = em3.getTransaction();
		txn3.begin();

		Message msg = new Message("Howdy"); //transient state
		em3.persist(msg); //persistent state

		em3.detach(msg); //detaching the message object explicitly
		txn3.commit();
		em3.close();
		*/

					//*******************************First-level Caching*************************************


		/*Message message1 = em.find(Message.class, 13L);// sql will be created for this statement
		Message message2 = em.find(Message.class, 13L);// get data from first level cache

		em.getTransaction().commit();
		em.close();
         em=null;//judy because of try catch finial*/


					// Is First-level Caching still going work?
		/*
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();

		Message message1 = em1.find(Message.class, 7L);

		em1.getTransaction().commit();
		em1.close();

		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();

		Message message2 = em2.find(Message.class, 7L);

		em2.getTransaction().commit();
		em2.close();
		*/

		//*********************************** Lazy and eager fetch



					/*//Lazy Collection Fetching with default settings(fetch=FetchType.LAZY for collection associations)
					Guide guide = em.find(Guide.class, 1L);
					Set<Student> students = guide.getStudents();
					//int numberOfStudents = students.size();
					//System.out.println(numberOfStudents);
					//Eager Fetching with default settings (fetch=FetchType.EAGER for single point associations)
					//Student student = em.find(Student.class, 1L);
                    Student student1=new Student();
					Student student2=new Student();
					System.out.println(student1.equals(student2));*/

					///******************** JPQL and HQL **********************
					/*Query query=em.createQuery("Select guide.name from Guide as guide where guide.salary>2000");
					List<String> list=query.getResultList();
					list.forEach(System.out::println);
                    List<Guide> query1= (List<Guide>) em.createNamedQuery("findByGuide").setParameter("name","omid").getResultList();
					for(Guide g: query1){
						System.out.println(g);
					}*/

					//Querying Entities

			/*
			Query query = em.createQuery("select guide from Guide guide");
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/

			/*
			Query query = em.createQuery("select guide.name from Guide guide");
			List<String> names = query.getResultList();
			for (String name : names) {
				System.out.println(name);
			}
			*/

					//############################


					//Reporting Queries
			/*
			Query query = em.createQuery("select guide.name, guide.salary from Guide guide");
			List<Object[]> resultList = query.getResultList();
			for (Object[] objects : resultList) {
				System.out.println("Object[] {objects[0]: " + objects[0] + ", objects[1]: " + objects[1] + "}");
			}
			*/

					//############################


					//Dynamic Queries
			/*
			String name = "Ian Lamb"; //simulating dynamic query
			Query query = em.createQuery("select guide from Guide guide where guide.name = '" + name + "'");
			Guide guide = (Guide) query.getSingleResult();
			System.out.println(guide);
			*/

			/*
			Query query = em.createQuery("select guide from Guide guide where guide.name = :name");
			query.setParameter("name", "Ian Lamb");
			Guide guide = (Guide) query.getSingleResult();
			System.out.println(guide);
			*/

					//############################


					//Chaining Method Calls
			/*
			Guide guide = (Guide) em.createQuery("select guide from Guide guide where guide.name = :name").
					        .setParameter("name", "Ian Lamb")
					        .getSingleResult();
			System.out.println(guide);
			*/

					//############################


					//Wildcards
			/*
			Query query = em.createQuery("select guide from Guide guide where guide.name like 'm%'");
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/

					//############################


					//Native SQL Queries
			/*
			Query query = em.createNativeQuery("select * from Guide", Guide.class);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/

					//############################

					//Named Queries
			/*
			List<Guide> guides = em.createNamedQuery("findByGuide")
					       						.setParameter("name", "Mike Lawson")
					       						.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/

			/*
			int numOfGuides = em.createQuery("select guide from Guide guide").getResultList().size();
			System.out.println("[numOfGuides: " + numOfGuides + "]");
			*/

					//############################


					//Aggregate Functions
			/*
			Query query = em.createQuery("select count(guide) from Guide guide");
			long numOfGuides = (long) query.getSingleResult();
			System.out.println("[numOfGuides: " + numOfGuides + "]");
			*/

			/*
			Query query = em.createQuery("select max(guide.salary) from Guide guide");
			Integer maximumSalary = (Integer) query.getSingleResult();
			System.out.println("[maximumSalary: " + maximumSalary + "]");
			*/

			/*
			Query query = em.createQuery("select guide from Guide guide where guide.salary = 1000");
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/

					//############################

					//Persisting a Student object
			/*
			Student student = new Student("2014BE50789", "Bruce Lee");
			em.persist(student);
			*/

					//############################

					//Joining Associations
			/*
			Query query = em.createQuery("select student from Student student join student.guide guide");
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			*/

			/*
			Query query = em.createQuery("select student from Student student left join student.guide guide");
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			*/

			/*
			Query query = em.createQuery("select student from Student student right join student.guide guide");
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			*/

					//############################


					//Fetching Associations
			/*
			Query query = em.createQuery("select guide from Guide guide join guide.students student");
			List<Guide> guides = query.getResultList();
			*/

			/*
			Query query = em.createQuery("select guide from Guide guide join fetch guide.students student");
			List<Guide> guides = query.getResultList();
			*/

               //********************************** Inheritance and polymorphism************************

					//Persisting a Cat and a Dog object
        			/*Cat cat = new Cat();
        			cat.setName("Lucy");

        			Dog dog = new Dog();
        			dog.setName("Oliver");

        			em.persist(cat);
        			em.persist(dog);
					txn.commit();*/
					//Polymorphic Query
        			/*Query query = em.createQuery("select animal from Animal animal");
        			List<Animal> animals = query.getResultList();
        			for (Animal animal : animals) {
        				System.out.println(animal);
        			}*/
					//Querying Derived Class (Dog)
        			/*List<Dog> dogs =em.createQuery("select dg FROM Dog dg").getResultList();
        			for (Dog d : dogs) {
					System.out.println(d);
				}*/

        			// **************** N +1 problem --- > solution Batch Fetching *************

					//Loading all the students lazily; the guides associated with students are "not" being accessed
			/*
			Query query = em.createQuery("select student from Student student");
			List<Student> students = query.getResultList();

			for (Student student : students) {
				System.out.println(student.getName() + ": " + student.getEnrollmentId());
			}
			*/

					//Loading all the students lazily using @BatchSize(size=2); the guides associated with students are being accessed
					/*Query query = em.createQuery("select student from Student student");
					List<Student> students = query.getResultList();

					for (Student student : students) {
						if(student.getGuide() != null) {
							System.out.println(student.getName() + ": " + student.getEnrollmentId() + ": " + student.getGuide().getName()+
												"  $"+student.getGuide().getSalary());
						}
					}*/

					//=============================
					//Detached Objects
					//=============================

					/*Guide guide = em.find(Guide.class, 2L);
					Set<Student> students = guide.getStudents();
					int numOfStudents = students.size(); // we use this statement to get associated collection
					                                     //it is possible to use contain() method

					Student student = null;
					for(Student nextStudent: students) {
						if(nextStudent.getId() == 3L) {
							student = nextStudent;
						}
					}

					em.getTransaction().commit();
					em.close();

					guide.setSalary(4000);
					student.setName("Amy Jade Gill");//only will be dirty if cascading --> MERGE

					EntityManager em2 = emf.createEntityManager();
					em2.getTransaction().begin();

					@SuppressWarnings("unused")
					Guide mergedGuide = em2.merge(guide);

					em2.getTransaction().commit();
					em2.close();*/

					//=============================
					//Extended Persistence Context
					//=============================

					Guide guide = em.find(Guide.class, 2L);
					Set<Student> students = guide.getStudents();
					int numOfStudents = students.size();

					Student student = null;
					for(Student nextStudent: students) {
						if(nextStudent.getId() == 4L) {
							student = nextStudent;
						}
					}

					em.getTransaction().commit();

					guide.setSalary(4000);
					student.setName("Amy Jade Gill extended persist");

					em.getTransaction().begin();

					//merging not needed

					em.getTransaction().commit();



					em.close();

				}
				catch(Exception e) {
					if(txn != null) { txn.rollback(); }
					e.printStackTrace();
				}	finally {
					if(em != null) { em.close(); }
				}

			}
}

