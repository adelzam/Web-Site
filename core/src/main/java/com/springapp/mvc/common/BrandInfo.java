package com.springapp.mvc.common;

import javax.persistence.*;

@Entity
@Table(name = "brand")
public class BrandInfo {

    /**
     * id of brand
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * name of brand
     */
    @Column(name = "name")
    private String name;

    /**
     * url to brand image
     */
    @Column(name = "imageURL")
    private String imageURL;

    /**
     * banner form brand
     */

    @Column(name = "bannerURL")
    private String bannerURL;
    public BrandInfo() {
    }
    public BrandInfo(Long id) {
        this.id = id;
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
