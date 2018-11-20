package com.atf.jdbc;

import cucumber.api.java.eo.Se;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

public class SalesDao implements Dao<Sales>{

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    private void OpenConnection()
    {
        try
        {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(registry).addAnnotatedClass(Sales.class).addResource("Mapping.hbm.xml").getMetadataBuilder().applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
            factory = metaData.getSessionFactoryBuilder().build();
        }
        catch (Exception e)
        {
            System.err.println("Failed to create session!" + e.getMessage());
        }
        session = factory.openSession();
    }

    @Override
    public Sales get(int id) {
        OpenConnection();
        transaction = session.beginTransaction();
        Sales sales = session.get(Sales.class, id);
        transaction.commit();
        session.close();
        return sales;
    }

    @Override
    public List<Sales> getAll() {
        OpenConnection();
        return null;
    }

    @Override
    public void save(Sales sales) {
        OpenConnection();
        transaction = session.beginTransaction();
        session.save(sales);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Sales sales, String[] params) {

    }

    @Override
    public void delete(Sales sales) {

    }
}
