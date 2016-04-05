package com.springapp.mvc.common;

import javax.persistence.*;

/**
 * Created by adelzamalutdinov on 04.04.16.
 */
@Entity
@Table(name = "cart")
public class CartInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "good_id")
    private GoodInfo goodInfo;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderInfo orderInfo;

    @Column(name = "number")
    private Integer number;

    public CartInfo() {
    }

    public CartInfo(GoodInfo goodInfo, OrderInfo orderInfo, Integer number) {
        this.goodInfo = goodInfo;
        this.orderInfo = orderInfo;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
