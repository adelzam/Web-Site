package com.springapp.mvc.repository;

import com.springapp.mvc.common.BrandInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 08.04.16.
 */
public interface BrandRepository extends JpaRepository<BrandInfo, Long> {

    List<BrandInfo> findAllByOrderById();
}
