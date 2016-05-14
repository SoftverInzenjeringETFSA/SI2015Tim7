package vozniPark.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import vozniPark.View.Login;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class HibernateUtil {
	
	final static Logger logger = Logger.getLogger(Login.class);

	private static final SessionFactory sessionFactory = buildSessionFactory();

	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
	            return new Configuration().configure().buildSessionFactory();
	        }
	        catch (Exception ex) {
	            // Make sure you log the exception, as it might be swallowed
	        	logger.info(ex);
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }


    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
