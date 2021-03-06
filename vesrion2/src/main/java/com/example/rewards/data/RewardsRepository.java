package com.example.rewards.data;

import lombok.NonNull;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class RewardsRepository {
    private static SessionFactory factory;

    public RewardsRepository() {
        try {
            factory = new Configuration().
                    configure("hibernate.cfg.xml").
                    addAnnotatedClass(Child.class).
                    addAnnotatedClass(Task.class).
                    addAnnotatedClass(Reward.class).
                    addAnnotatedClass(Profile.class).
                    addAnnotatedClass(Schedule.class).
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Child getChild(int id) {
        var session = factory.openSession();

        try {
            return session.get(Child.class, id);
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }

        return null;
    }

    public Iterable<Child> getChilds() {
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Child").list();
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }

        return new ArrayList<>();
    }

    public Task getTask(int id) {
        var session = factory.openSession();

        try {
            return session.get(Task.class, id);
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }

        return null;
    }

    public Iterable<Task> getTasks() {
        var session = factory.openSession();

        try {
            return session.createQuery("from Task").list();
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    public Iterable<Reward> getRewards() {
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Reward").list();
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }

        return new ArrayList<>();
    }

    public Iterable<Profile> getProfileTasks() {
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Task").list();
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    public Iterable<Schedule> getSchedule(int childId) {
        var session = factory.openSession();

        try {
            var sql = "FROM Schedule where child_id = :childId";
            var query = session.createQuery(sql);
            query.setParameter("childId", childId);
            var result = query.list();
            return result;
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }

        return new ArrayList<>();
    }

    public Iterable<Task> getChildTasks(int childId) {
        var session = factory.openSession();

        try {
            var sql = "FROM Task where child_id = :childId";
            var query = session.createQuery(sql);
            query.setParameter("childId", childId);
            var result = query.list();
            return result;
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }

        return new ArrayList<>();
    }



    public void save(@NonNull Object item) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(item);
            tx.commit();
        } catch (HibernateException exception) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }

    public void addChild(@NonNull Child child) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(child);
            tx.commit();
        } catch (HibernateException exception) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }

    public void deleteChild(int id) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            var child = session.get(Child.class, id);
            if(child != null) {
                session.delete(child);
            }
            tx.commit();
        } catch (HibernateException exception) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }

    public void addTask(@NonNull Task task) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(task);
            tx.commit();
        } catch (HibernateException exception) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }

    public void deleteTask(int id) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            var task = session.get(Task.class, id);
            if(task != null) {
                session.delete(task);
            }
            tx.commit();
        } catch (HibernateException exception) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }

    public boolean markAsDone(int id) {                         // ?
        var session = factory.openSession();
        Transaction tx = null;

        try {
            var sql = "FROM Task where isItDone = :isItDone";
            var query = session.createQuery(sql);
            query.setParameter(1, Task.class);
            return true;
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }

        return false;
    }
}
