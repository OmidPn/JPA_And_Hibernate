package client;

import entity.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


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

					// Using JPA instead of Hibernate to manage session by using --> entity manager


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
		*/	;
				}	catch(Exception e) {
					if(txn != null) { txn.rollback(); }
					e.printStackTrace();
				}	finally {
					if(em != null) { em.close(); }
				}

			}
}

