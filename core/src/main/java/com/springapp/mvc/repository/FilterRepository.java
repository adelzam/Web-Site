package com.springapp.mvc.repository;

import com.springapp.mvc.common.FilterInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adelzamalutdinov on 09.04.16.
 */
public interface FilterRepository extends JpaRepository<FilterInfo, Long> {
}
