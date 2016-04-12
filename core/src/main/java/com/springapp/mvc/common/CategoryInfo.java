package com.springapp.mvc.common;

import javax.persistence.*;
import java.util.List;

/**
 * Информация о категории
 */
@Entity
@Table(name = "category")
public class CategoryInfo {

    /**
     * id of category
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * category name
     */
    @Column(name = "name", length = 120, nullable = false)
    private String name;

    /**
     * list of subcategories
     */
    @OneToMany(mappedBy = "parent")
    private List<CategoryInfo> children;
    /**
     * parent category
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CategoryInfo parent;

    public CategoryInfo() {
    }

    public CategoryInfo(Long id, String name, CategoryInfo parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryInfo> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryInfo> children) {
        this.children = children;
    }

    public CategoryInfo getParent() {
        return parent;
    }

    public void setParent(CategoryInfo parent) {
        this.parent = parent;
    }
}
