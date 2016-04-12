package com.springapp.mvc.repository;

import com.springapp.mvc.common.BrandInfo;
import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
public interface GoodRepository extends JpaRepository<GoodInfo, Long> {
    /**
     * @param category_id
     * @return list of goods by category
     */

    List<GoodInfo> findGoodsByCategoryIdOrderByPopularityAsc(Long category_id);

    List<GoodInfo> findGoodsByCategory_IdAndBrand_IdOrderByPopularityAsc(Long category_id, Long brand_id);

    List<GoodInfo> findTop6ByOrderByPopularityAsc();

}
