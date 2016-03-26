package com.springapp.mvc.repository.hibernate;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.GoodRepository;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

/**
 * Created by adelzamalutdinov on 26.03.16.
 */
public class GoodRepositoryHibernate implements GoodRepository{
    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addGood(GoodInfo goodInfo) {
        curSession().save(goodInfo);
    }

    @Override
    public void updateGood(GoodInfo goodInfo) {
        curSession().saveOrUpdate(goodInfo);
    }

    @Override
    public void deleteGood(Long goodId) {
        curSession().delete(new GoodInfo(goodId));
    }

    @Override
    public GoodInfo getGoodById(Long goodId) {
        return (GoodInfo) curSession().get(GoodInfo.class, goodId);
    }

    @Override
    public List<GoodInfo> getGoodsByCategory(CategoryInfo categoryInfo) {
        Query query = curSession().createSQLQuery("select g.name, g.brand, g.country, g.price," +
                "g.imageURL, g.description from goods g where g.category_id = :category");
        query.setParameter("category", categoryInfo);
        return (List<GoodInfo>) query.list();
    }

    @Override
    public List<GoodInfo> getAllGood() {
        return (List<GoodInfo>) curSession().createSQLQuery("select * from goods g").list();
    }
}
