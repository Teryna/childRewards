package com.example.rewards.data;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
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
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
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

    public Iterable<Task> getTasks() {
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
}
