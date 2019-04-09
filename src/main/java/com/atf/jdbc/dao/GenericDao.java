package com.atf.jdbc.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public interface GenericDao<T, Z> {
    default T get(Z id) {
        return getEntityManager().find(getEntityBeanType(), id);
    }

    default List<T> getAll() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getEntityBeanType());
        Root<T> root = cq.from(getEntityBeanType());
        cq.select(root).orderBy();
        return getEntityManager().createQuery(cq).getResultList();
    }

    default void save(T t) {
        getEntityManager().persist(t);
    }

    default void update(T t) {
        getEntityManager().merge(t);
    }

    default void delete(T t) {
        getEntityManager().remove(t);
    }

    Class<T> getEntityBeanType();

    EntityManager getEntityManager();

    void setEntityManager(EntityManager entityManager);
}
