package com.springapp.mvc.common;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Основная информация о товаре
 */
@Entity
@Table(name = "goods")
public class GoodInfo {

    /**
     * id товара
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Название товара
     */
    @Column(name = "name", length = 120, nullable = false)
    private String name;

    /**
     * Бренд производителя
     */

    @Column(name = "brand", length = 120, nullable = false)
    private String brand;

    /**
     * Страна происхождения товара
     */

    @Column(name = "country", length = 120, nullable = false)
    private String country;

    /**
     * Цена товара
     */
    @Column(name = "prise")
    private BigDecimal prise;

    /**
     * id категории товара
     */

    @ManyToOne(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryInfo category;


    /**
     * URL to image of good
     */
    @Column(name = "imageURL")
    private String imageURL;

    /**
     * Good description
     */
    @Column(name = "description")
    private String description;

    public GoodInfo() {
    }

    public GoodInfo(String name, String brand, String country, BigDecimal prise, CategoryInfo category) {
        this.name = name;
        this.brand = brand;
        this.country = country;
        this.prise = prise;
        this.category = category;
    }

    public GoodInfo(String name, String brand, String country, BigDecimal prise, CategoryInfo category, String imageURL) {
        this.name = name;
        this.brand = brand;
        this.country = country;
        this.prise = prise;
        this.category = category;
        this.imageURL = imageURL;
    }

    public GoodInfo(String name, String brand, String country, BigDecimal prise, CategoryInfo category, String imageURL, String description) {
        this.name = name;
        this.brand = brand;
        this.country = country;
        this.prise = prise;
        this.category = category;
        this.imageURL = imageURL;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getPrise() {
        return prise;
    }

    public void setPrise(BigDecimal prise) {
        this.prise = prise;
    }

    public CategoryInfo getCategory() {
        return category;
    }

    public void setCategory(CategoryInfo category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
