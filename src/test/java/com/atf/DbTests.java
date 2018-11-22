package com.atf;

import com.atf.jdbc.Dao;
import com.atf.jdbc.Sales;
import com.atf.jdbc.SalesDao;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

public class DbTests {

    @Test
    @Ignore
    public void GetOrderDetails()
    {
        Sales sales = new Sales();
        Dao<Sales> dao = new SalesDao();
        sales = dao.get(26278);

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
    }
}
