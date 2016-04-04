package com.springapp.mvc.common;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
@Entity
@Table(schema = "orders")
public class OrderInfo {

    /**
     * order id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * creation date
     */
    @Column
    private Date creationDate;

    public OrderInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
