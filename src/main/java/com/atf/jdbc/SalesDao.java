package com.atf.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        Sales sales = new Sales();
        OpenConnection();
        try {
            transaction = session.beginTransaction();
            sales = session.get(Sales.class, id);
            transaction.commit();
        }
        catch (Exception ex) {
            Assert.assertTrue(ex.getCause().getMessage(), false);
        }
        finally {
            session.close();
            return sales;
        }
    }

    @Override
    public List<Sales> getAll() {
        String query = "FROM Sales";
        OpenConnection();
        List<Sales> allSales = new ArrayList <>();
        try {
            transaction = session.beginTransaction();
            allSales.addAll(session.createQuery(query, Sales.class).list());
            transaction.commit();
        }
        catch (Exception ex)
        {
            Assert.assertTrue(ex.getCause().getMessage(), false);
        }
        finally {
            session.close();
            return allSales;
        }
    }

    @Override
    public void save(Sales sales) {
        OpenConnection();
        try {
            transaction = session.beginTransaction();
            session.save(sales);
            transaction.commit();
        }
        catch (Exception ex) {
            Assert.assertTrue(ex.getCause().getMessage(), false);
        }
        finally {
            session.close();
        }
    }

    @Override
    public void update(Sales sales, String[] params) {

    }

    @Override
    public void delete(Sales sales) {

    }
}
