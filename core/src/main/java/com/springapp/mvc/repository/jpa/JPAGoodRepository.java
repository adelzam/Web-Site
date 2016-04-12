package com.springapp.mvc.repository.jpa;

import com.springapp.mvc.common.BrandInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.GoodRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by adelzamalutdinov on 09.04.16.
 */
@Repository
public class JPAGoodRepository implements GoodRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    private static final String SQL_BRAND_QUERY = "SELECT g FROM GoodInfo g where g.brand.id=? and g.category.id in ?";

    private static final String SQL_BRAND_0_QUERY = "SELECT g FROM GoodInfo g where g.category.id in ?";

    /**
     *
     * @param order type of order
     * @param brand brand of good's
     * @param category good's category
     * @return get gooods with current category and(or) current brand in current order
     */
    @Override
    public List<GoodInfo> getGoodsInOrder(String order, BrandInfo brand, List<Long> category) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<GoodInfo> query = cb.createQuery(GoodInfo.class);
        Root<GoodInfo> root = query.from(GoodInfo.class);
        if (brand.getId() != 0L) {
            query.select(root).where(cb.isTrue(root.get("brand").in(brand))
                    , cb.isTrue(root.get("category").in(category)))
                    .orderBy(cb.asc(root.get(order)));
        } else {
            query.select(root).where(cb.isTrue(root.get("category").in(category)))
                    .orderBy(cb.asc(root.get(order)));
        }
        return em.createQuery(query).getResultList();
    }
}
