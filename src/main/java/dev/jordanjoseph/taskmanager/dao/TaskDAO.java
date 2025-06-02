package dev.jordanjoseph.taskmanager.dao;

import dev.jordanjoseph.taskmanager.model.Task;
import dev.jordanjoseph.taskmanager.util.HibernateUtil;
import dev.jordanjoseph.taskmanager.util.LoggerUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class TaskDAO {

    private final SessionFactory sessionFactory;

    public TaskDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void save(Task task) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(task);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) tx.rollback(); //reverts changes
            LoggerUtil.logger.error("Failed to save task", e);
        }
    }

    public List<Task> findAll() {
        List<Task> tasks;
        try(Session session = sessionFactory.openSession()) {
            Query<Task> query = session.createQuery("from Task", dev.jordanjoseph.taskmanager.model.Task.class);
            tasks = query.getResultList();
            return tasks;
        } catch (Exception e) {
            LoggerUtil.logger.error("Failed to find all tasks", e);
        }
        return Collections.emptyList();
    }

    public Task findById(Long id) {
        Task task = null;
        try(Session session = sessionFactory.openSession()) {
            task = session.find(dev.jordanjoseph.taskmanager.model.Task.class, id);

        } catch (Exception e) {
            LoggerUtil.logger.error("Failed to find task by id", e);
        }
        return task;
    }

    public void update(Task task) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.merge(task);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) tx.rollback();
            LoggerUtil.logger.error("Failed to update task", e);
        }
    }

    public void delete(Task task) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.remove(task);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) tx.rollback();
            LoggerUtil.logger.error("Failed to delete task", e);
        }
    }
}
