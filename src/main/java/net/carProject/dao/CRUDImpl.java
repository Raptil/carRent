package net.carProject.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


public abstract class CRUDImpl<T> {

    protected EntityManager entityManager = HibernateUtil.getEm();


    private Class<T> type;

    public CRUDImpl(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    @Transactional
    public void save(T newInstance) {
        entityManager.getTransaction().begin();
        entityManager.persist(newInstance);
        entityManager.getTransaction().commit();
        entityManager.detach(newInstance);
    }

    public T read(int id) {

        T entity = (T) entityManager.find(type, id);
        entityManager.detach(entity);
        return entity;
    }

    public List<T> readAll() {
        List<T> query = entityManager.createQuery("FROM " + type.getSimpleName()).getResultList();
        return query;
    }

    @Transactional
    public T update(T transientObject) {
        entityManager.getTransaction().begin();
        T entity = entityManager.merge(transientObject);
        entityManager.getTransaction().commit();
        entityManager.detach(transientObject);
        return entity;
    }

    @Transactional
    public void remove(T persistenceObject) {
        entityManager.getTransaction().begin();
        entityManager.remove(persistenceObject);
        entityManager.getTransaction().commit();
        entityManager.detach(persistenceObject);
    }

    @Transactional
    public void remove(int id) {
        T entity = (T) entityManager.find(type, id);
        if (entity != null) {
            remove(entity);
        }
    }

}
