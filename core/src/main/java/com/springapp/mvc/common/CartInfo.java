package com.springapp.mvc.common;

import javax.persistence.*;


@Entity
@Table(name = "cart")
public class CartInfo {
    /**
     * cart id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * good id was added into the cart
     */
    @ManyToOne
    @JoinColumn(name = "good_id")
    private GoodInfo goodInfo;

    /**
     * who added good into cart
     */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderInfo orderInfo;

    /**
     * number of goods
     */
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

    public GoodInfo getGoodInfo() {
        return goodInfo;
    }

    public void setGoodInfo(GoodInfo goodInfo) {
        this.goodInfo = goodInfo;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
