package dev.jordanjoseph.taskmanager.dao;

import dev.jordanjoseph.taskmanager.model.Task;
import dev.jordanjoseph.taskmanager.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TaskDAO {

    private final SessionFactory sessionFactory;

    public TaskDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void createTask(Task task) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(task);
            tx.commit();
        } catch (Exception e ) {
            if(tx != null) tx.rollback(); //reverts changes
            e.printStackTrace();
        }
    }
}
