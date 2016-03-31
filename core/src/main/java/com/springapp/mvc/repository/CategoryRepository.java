package com.springapp.mvc.repository;

import com.springapp.mvc.common.CategoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
public interface CategoryRepository extends JpaRepository<CategoryInfo, Long> {

    List<CategoryInfo> findCategoriesByParent(Long parent_id);
}
