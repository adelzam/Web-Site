package com.springapp.mvc.repository.jdbc;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
@Repository
public class CategoryRepositoryJdbc implements CategoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String ADD_NEW_CATEGORY ="INSERT INTO category (name, parent_id) VALUES (?,?)";

    private static final String GET_SUBCATEGORIES="SELECT (name) FROM category where parent_id=?";

    private static final String GET_CATEGORY_BY_ID="SELECT (name) FROM category WHERE id=?";

    private static final String GET_ALL="SELECT (name) FROM category";
    @Override
    public void addCategory(CategoryInfo categoryInfo) {
        jdbcTemplate.update(ADD_NEW_CATEGORY, categoryInfo.getName(),  categoryInfo.getParent());
    }

    @Override
    public List<CategoryInfo> getSubcategories(final CategoryInfo categoryInfo) {


        return jdbcTemplate.query(GET_SUBCATEGORIES,getNewRowMapper(), categoryInfo.getId());
    }

    @Override
    public CategoryInfo getCategoryById(Long id) {
        List<CategoryInfo> results = jdbcTemplate.query(GET_CATEGORY_BY_ID, getNewRowMapper(), id);
        if (results.isEmpty()) {
            return null;
        } else if (results.size() == 1) {
            return results.get(0);
        } else {
            throw new IllegalArgumentException("Your database contains " + results.size() + " goods with id = " + id);
        }
    }

    @Override
    public List<CategoryInfo> getAllCategories() {
        return jdbcTemplate.query(GET_ALL,getNewRowMapper());
    }


    private RowMapper<CategoryInfo> getNewRowMapper() {
        RowMapper<CategoryInfo> rm = new RowMapper<CategoryInfo>() {
            @Override
            public CategoryInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                CategoryInfo category = new CategoryInfo();
                category.setId(rs.getLong("id"));
                category.setName(rs.getString("name"));
                category.setParent((CategoryInfo) rs.getObject("parent_id"));
                return category;
            }
        };
        return rm;
    }
}
