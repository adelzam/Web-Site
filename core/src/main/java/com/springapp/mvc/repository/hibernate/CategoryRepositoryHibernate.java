package com.springapp.mvc.repository.hibernate;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by adelzamalutdinov on 26.03.16.
 */
public class CategoryRepositoryHibernate implements CategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCategory(CategoryInfo categoryInfo) {
        curSession().save(categoryInfo);
    }

    @Override
    public List<CategoryInfo> getSubcategories(CategoryInfo categoryInfo) {
        return  (List<CategoryInfo>) curSession().createSQLQuery("SELECT c.id, c.name FROM category c where c.parent_id=?").setParameter(1,categoryInfo).list();
    }

    @Override
    public CategoryInfo getCategoryById(Long id) {
        return (CategoryInfo) curSession().get(GoodInfo.class, id);
    }

    @Override
    public List<CategoryInfo> getAllCategories() {
        return (List<CategoryInfo>) curSession().createSQLQuery("SELECT c.id, c.name FROM category c").list();
    }
}
