package com.crashtech.trendspisrv.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Trend {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private Integer stars;
    @Field
    private boolean popular;
    @Field
    private Integer likes;
    @Field
    private boolean expired;
    @Field
    private String imageURL;
    @Field
    private  String thumbnailURL;

    public Trend(String id,
                 String name,
                 Integer stars,
                 boolean popular,
                 Integer likes,
                 boolean expired,
                 String imageURL,
                 String thumbnailURL) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.popular = popular;
        this.likes = likes;
        this.expired = expired;
        this.imageURL = imageURL;
        this.thumbnailURL = thumbnailURL;
    }

    public Trend() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public boolean isPopular() {
        return popular;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    @Override
    public String toString() {
        return "Trend{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", popular=" + popular +
                ", likes=" + likes +
                ", expired=" + expired +
                ", imageURL='" + imageURL + '\'' +
                ", thumbnailURL='" + thumbnailURL + '\'' +
                '}';
    }
}
