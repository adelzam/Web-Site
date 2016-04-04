package com.springapp.mvc.repository;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
public interface GoodRepository extends JpaRepository<GoodInfo, Long> {

    List<GoodInfo> findGoodsByCategory(Long category_id);

}
