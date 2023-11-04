package com.problem4a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.problem3a.HibernateUtil;

public class MovieActorApp {

	
	    public static void main(String[] args) {
	    	
	    	
	    	
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        Transaction txn = session.beginTransaction();

	        try {
	            
	            Actor actor1 = new Actor("Allu Arjun");
	            Actor actor2 = new Actor("N.T.R");

	           
	            Movie movie1 = new Movie("Pushpa");
	            Movie movie2 = new Movie("R.R.R");

	          
	            
	            movie1.addActor(actor2);
	            movie2.addActor(actor2);

	            // automatically saved
	            
	            session.persist(movie1);
	            session.persist(movie2);

	            txn.commit();
	            
	        } catch (Exception e) {
	        	
	            if (txn != null) {
	            	
	                txn.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	        	
	            if (session != null) {
	            	
	                session.close();
	            }
	            sessionFactory.close();
	        }
	    }
	}
