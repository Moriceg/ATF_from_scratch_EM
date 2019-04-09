package com.atf.jdbc.service;

import com.atf.jdbc.dao.SalesDao;
import com.atf.jdbc.model.Sales;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements GenericService {

    private final SalesDao salesDao;

    @Override
    public List<Sales> getSalesByQuantity(Integer quantity){
        return salesDao.getSalesByQuantity(quantity);
    }

}
