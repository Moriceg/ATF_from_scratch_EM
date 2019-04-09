package com.atf.jdbc.dao;

import com.atf.jdbc.model.Sales;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SalesDao extends AbstractGenericDao<Sales, Integer> {

    public SalesDao() {
        super(Sales.class);
    }

    public List<Sales> getSalesByQuantity(Integer numberOfOrders) {
        return getAll().stream()
                .filter(p -> p.getOrderQty() >= numberOfOrders)
                .collect(Collectors.toList());
    }
}
