package com.maiyon.model.dao;

import com.maiyon.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOImp implements CategoryDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            categories = session.createQuery("from Category", Category.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findById(Integer id) {
        Session session = sessionFactory.openSession();
        try{
            Category category = session.get(Category.class, id);
            return category;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Boolean saveOrUpdate(Category category) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
