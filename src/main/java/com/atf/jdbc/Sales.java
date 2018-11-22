package com.atf.jdbc;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Sales")
@IdClass(Sales.class)
public class Sales implements Serializable {

    //@Column(name = "SalesOrderID", nullable = false)
    private int SalesOrderID;
    //@Column(name = "SalesOrderDetailID",  nullable = false)
    private int SalesOrderDetailID;
    //@Column(name = "OrderQty", nullable = false)
    private short OrderQty;
    //@Column(name = "ProductID", nullable = false)
    private int ProductID;
    //@Column(name = "UnitPrice", nullable = false)
    private double UnitPrice;
    //@Column(name = "UnitPriceDiscount", nullable = false)
    private double UnitPriceDiscount;
    //@Column(name = "rowguid", nullable = false)
    private int rowguid;
    //@Column(name = "ModifiedDate", nullable = false)
    private Date ModifiedDate;

    public int getSalesOrderID() {
        return SalesOrderID;
    }

    public void setSalesOrderID(int salesOrderID) {
        SalesOrderID = salesOrderID;
    }

    public int getSalesOrderDetailID() {
        return SalesOrderDetailID;
    }

    public void setSalesOrderDetailID(int salesOrderDetailID) {
        SalesOrderDetailID = salesOrderDetailID;
    }

    public short getOrderQty() {
        return OrderQty;
    }

    public void setOrderQty(short orderQty) {
        OrderQty = orderQty;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public double getUnitPriceDiscount() {
        return UnitPriceDiscount;
    }

    public void setUnitPriceDiscount(double unitPriceDiscount) {
        UnitPriceDiscount = unitPriceDiscount;
    }

    public int getRowguid() {
        return rowguid;
    }

    public void setRowguid(int rowguid) {
        this.rowguid = rowguid;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        ModifiedDate = modifiedDate;
    }

    public String ToString()
    {
        return "SalesOrderID: " + getSalesOrderID() + " SalesOrderID: " + getSalesOrderDetailID() + " OrderQty: " + getOrderQty() +
                " ProductID: " + getProductID() + " UnitPrice: " + getUnitPrice() + " UnitPriceDiscount: " + getUnitPriceDiscount() +
                " RowGuid: " + getRowguid() + " DateOfOrder: " + getModifiedDate();
    }
}