package com.atf;

import com.atf.jdbc.Sales;
import com.atf.jdbc.SalesDao;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

public class DbTests {

    @Test
    @Ignore
    public void GetOrderDetails()
    {
        Sales sales = new Sales();
        SalesDao dao = new SalesDao();
        sales = dao.get(26278);

        System.out.println(sales.ToString());
    }

    @Test
    public void SaveOrder()
    {
        Sales sales = new Sales();
        sales.setSalesOrderID(111);
        //sales.setSalesOrderDetailID(111111);
        sales.setOrderQty((short)1);
        sales.setProductID(222);
        sales.setUnitPrice(400.01);
        sales.setUnitPriceDiscount(5.00);
        sales.setRowguid(10);
        sales.setModifiedDate(new Date());
        SalesDao dao = new SalesDao();

        dao.save(sales);
        System.out.println(sales.ToString());
    }
}
