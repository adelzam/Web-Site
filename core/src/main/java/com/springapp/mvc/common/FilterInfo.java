package com.springapp.mvc.common;

import com.springapp.mvc.utils.OrderTypes;

import javax.persistence.*;

/**
 * Created by adelzamalutdinov on 08.04.16.
 */
@Entity
@Table(name = "filters")
public class FilterInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column (name = "description")
    private String description;

    public FilterInfo() {
    }

    public FilterInfo(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
