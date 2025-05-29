package dev.jordanjoseph.taskmanager.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                //load properties file from resources
                Properties properties = new Properties();
                try(InputStream inputStream = HibernateUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
                    if(inputStream == null) {
                        throw new RuntimeException("Unable to find db.properties.");
                    }
                    properties.load(inputStream);
                }

                Configuration configuration = new Configuration();
                configuration.setProperties(properties);

                //add annotated entity classes
                configuration.addAnnotatedClass(dev.jordanjoseph.taskmanager.model.Task.class);

                sessionFactory = configuration.buildSessionFactory();

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error loading Hibernate properties.", e);
            }
        }
        return sessionFactory;
    }

}
