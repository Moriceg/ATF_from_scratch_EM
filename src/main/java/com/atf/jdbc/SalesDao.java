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

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class SalesDao implements Dao<Sales>{

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private final String deleteQuery  = "delete from Sales;";

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

    @Transactional
    private void PrepareDatabase()
    {
        String testData = "INSERT INTO Sales (SalesOrderID,SalesOrderDetailID,OrderQty,ProductID,UnitPrice,UnitPriceDiscount,rowguid,ModifiedDate) " +
                "VALUES (26271,110562,1,836,356.89,0.00,'1','2008-06-01 00:00:00.000'), " +
                "(26272,110563,1,822,356.89,0.00,'2','2008-06-01 00:00:00.000'), " +
                "(26273,110567,1,907,163.90,0.00,'3','2008-06-01 00:00:00.000'), " +
                "(26274,110616,4,905,218.45,0.00,'4','2008-06-01 00:00:00.000'), " +
                "(26275,110617,2,983,461.69,0.00,'5','2008-06-01 00:00:00.000'), " +
                "(26276,110618,6,988,112.99,0.40,'6','2008-06-01 00:00:00.000'), " +
                "(26277,110619,2,748,818.70,0.00,'7','2008-06-01 00:00:00.000'), " +
                "(26278,110620,1,990,323.99,0.00,'8','2008-06-01 00:00:00.000'), " +
                "(26279,110621,1,926,149.87,0.00,'9','2008-06-01 00:00:00.000');";

        OpenConnection();
        transaction = session.beginTransaction();
        Query sqlQuery = session.createSQLQuery(deleteQuery);
        sqlQuery.executeUpdate();
        transaction.commit();
        transaction.begin();
        sqlQuery = session.createSQLQuery(testData);
        sqlQuery.executeUpdate();
        transaction.commit();
    }

    @Override
    public Sales get(int id) {
        PrepareDatabase();
        if(session == null) OpenConnection();
        Sales sales = new Sales();
        try {
            transaction = session.beginTransaction();
            sales = session.get(Sales.class, id);
            transaction.commit();
        }
        catch (Exception ex) {
            Assert.assertTrue(ex.getCause().getMessage(), false);
            if(transaction != null) transaction.rollback();
        }
        finally {
            session.close();
            return sales;
        }
    }

    @Override
    public List<Sales> getAll() {
        PrepareDatabase();
        String query = "FROM Sales";
        if(session == null) OpenConnection();
        List<Sales> allSales = new ArrayList <>();
        try {
            transaction = session.beginTransaction();
            allSales.addAll(session.createQuery(query, Sales.class).list());
            transaction.commit();
        }
        catch (Exception ex)
        {
            Assert.assertTrue(ex.getCause().getMessage(), false);
            if(transaction != null) transaction.rollback();
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
            if(transaction != null) transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void update(Sales sales) {
        PrepareDatabase();
        if(session == null) OpenConnection();
        try {
            transaction = session.beginTransaction();
            session.update(sales);
            transaction.commit();
        }
        catch (Exception ex) {
            Assert.assertTrue(ex.getCause().getMessage(), false);
            if(transaction != null) transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void delete(Sales sales) {

    }

    @Override
    public void deleteAll() {
        OpenConnection();
        try {
            transaction = session.beginTransaction();
            Query sqlQuery = session.createSQLQuery(deleteQuery);
            sqlQuery.executeUpdate();
            transaction.commit();
        }
        catch (Exception ex) {
            Assert.assertTrue(ex.getCause().getMessage(), false);
            if(transaction != null) transaction.rollback();
        }
        finally {
            session.close();
        }
    }
}
