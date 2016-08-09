package com.maolv.tmall.bean;

/**
 * Created by zhujingling on 16/5/15.
 */

/**
 * 产品信息
 */
public class GoodInfo {
    private String image;
    private String introductions;//说明
    private String specifications;// 规格
    private String fresh;//新鲜
    private String prices;//价格


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroductions() {
        return introductions;
    }

    public void setIntroductions(String introductions) {
        this.introductions = introductions;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getFresh() {
        return fresh;
    }

    public void setFresh(String fresh) {
        this.fresh = fresh;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }
}
