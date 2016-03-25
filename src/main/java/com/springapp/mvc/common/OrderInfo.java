package com.springapp.mvc.common;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
@Entity
@Table(schema = "orders")
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date creationDate;
}
