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
    public BrandInfo(Long id, String name, String imageURL, String bannerURL) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandInfo brandInfo = (BrandInfo) o;

        if (id != null ? !id.equals(brandInfo.id) : brandInfo.id != null) return false;
        if (name != null ? !name.equals(brandInfo.name) : brandInfo.name != null) return false;
        if (imageURL != null ? !imageURL.equals(brandInfo.imageURL) : brandInfo.imageURL != null) return false;
        return bannerURL != null ? bannerURL.equals(brandInfo.bannerURL) : brandInfo.bannerURL == null;

    }

}
