package com.atf.jdbc.service;

import com.atf.jdbc.model.Sales;

import java.util.List;

public interface GenericService {

    List<Sales> getSalesByQuantity(Integer quantity);

}
