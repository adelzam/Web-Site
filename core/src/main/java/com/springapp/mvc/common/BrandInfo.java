package com.springapp.mvc.common;

import javax.persistence.*;

/**
 * Created by adelzamalutdinov on 07.04.16.
 */
@Entity
@Table(name = "brand")
public class BrandInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "bannerURL")
    private String bannerURL;
    public BrandInfo() {
    }

    public BrandInfo(String name, String imageURL, String bannerURL) {
        this.name = name;
        this.imageURL = imageURL;
        this.bannerURL = bannerURL;
    }

    public String getBannerURL() {
        return bannerURL;
    }

    public void setBannerURL(String bannerURL) {
        this.bannerURL = bannerURL;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
