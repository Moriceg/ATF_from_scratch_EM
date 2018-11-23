package com.atf;

import com.atf.jdbc.Dao;
import com.atf.jdbc.Sales;
import com.atf.jdbc.SalesDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DbTests {

    @Test
    public void GetOrderDetails()
    {
        int orderID = 26278;
        Sales sales;
        Dao<Sales> dao = new SalesDao();
        dao.prepareDatabase();
        sales = dao.get(orderID);

        System.out.println(sales.ToString());
    }

    @Test
    public void SaveOrder()
    {
        Sales sales = new Sales();
        sales.setSalesOrderID(new Random().nextInt(10000));
        sales.setSalesOrderDetailID(new Random().nextInt(5000));
        sales.setOrderQty((short)(new Random().nextInt(30)));
        sales.setProductID(new Random().nextInt(300));
        sales.setUnitPrice(new Random().nextInt(500));
        sales.setUnitPriceDiscount(new Random().nextInt(10));
        sales.setRowguid(new Random().nextInt(20));
        sales.setModifiedDate(new Date());
        Dao<Sales> dao = new SalesDao();
        dao.save(sales);
        System.out.println(sales.ToString());
        Sales savedSale = dao.get(sales.getSalesOrderID());
        Assert.assertEquals("Sales was saved wrong!", sales.getSalesOrderDetailID(), savedSale.getSalesOrderDetailID());
        System.out.print("Item " + sales.getSalesOrderID() + " saved.");
    }

    @Test
    public void GetAllSales()
    {
        Dao<Sales> dao = new SalesDao();
        dao.prepareDatabase();
        List<Sales> allSales = dao.getAll();
        Iterator<Sales> iterator = allSales.iterator();
        if(allSales.size() == 0)
        {
            System.out.println("No records found or something went wrong during information retrieve!");
            return;
        }
        System.out.println("Records found: " + allSales.size());
        while(iterator.hasNext())
        {
            Sales sales = iterator.next();
            System.out.println(sales.ToString());
        }
    }

    @Test
    public void deleteAllRecords()
    {
        Dao<Sales> dao = new SalesDao();
        dao.prepareDatabase();
        dao.deleteAll();
        List<Sales> allSales = dao.getAll();
        Assert.assertEquals("The records were not deleted!", 0, allSales.size());
        System.out.print("Table is clear.");

    }

    @Test
    public void updateOrder()
    {
        int orderID = 26274;
        Dao<Sales> dao = new SalesDao();
        dao.prepareDatabase();
        Sales oldSales = dao.get(orderID);
        oldSales.setUnitPrice(9999.99);
        dao.update(oldSales);
        System.out.println("Old Unit price : " + oldSales.getUnitPrice());
        System.out.println("New Unit price : " + oldSales.getUnitPrice());
        Sales updatedSale = dao.get(orderID);
        if(oldSales.getUnitPrice() == updatedSale.getUnitPrice()) System.out.print("Sales updated!"); else System.out.print("Sales was not updated!");
    }

    @Test
    public void deleteOrder()
    {
        int orderToDelete = 26272;
        Dao<Sales> dao = new SalesDao();
        dao.prepareDatabase();
        int beforeDeleteCount = dao.getAll().size();
        Sales order = dao.get(orderToDelete);
        dao.delete(order);
        int afterDeleteCount = dao.getAll().size();
        Assert.assertEquals("Order was not deleted!", afterDeleteCount, beforeDeleteCount - 1);
    }
}
