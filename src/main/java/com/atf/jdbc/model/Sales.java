package com.atf.jdbc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalesOrderID", nullable = false)
    private int SalesOrderID;

    @Column(name = "SalesOrderDetailID", nullable = false)
    private int SalesOrderDetailID;

    @Column(name = "OrderQty", nullable = false)
    private short OrderQty;

    @Column(name = "ProductID", nullable = false)
    private int ProductID;

    @Column(name = "UnitPrice", nullable = false)
    private double UnitPrice;

    @Column(name = "UnitPriceDiscount", nullable = false)
    private double UnitPriceDiscount;

    @Column(name = "rowguid", nullable = false)
    private int rowguid;

    @Column(name = "ModifiedDate", nullable = false)
    private Date ModifiedDate;

}