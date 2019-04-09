package com.atf.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional(transactionManager = "ccTransactionManager")
public abstract class AbstractGenericDao<T, Z> implements GenericDao<T, Z> {

    @PersistenceContext(unitName = "persistence.cc")
    @Autowired
    @Qualifier("ccEntityManager")
    private EntityManager entityManager;

    private Class<T> entityBeanType;

    public AbstractGenericDao(Class<T> entityBeanType) {
        this.entityBeanType = entityBeanType;
    }

    @Override
    public Class<T> getEntityBeanType() {
        return entityBeanType;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
