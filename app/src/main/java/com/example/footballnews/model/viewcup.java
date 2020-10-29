package com.example.footballnews.model;

import java.io.Serializable;

public class viewcup implements Serializable {
    private String Header;
    private String Image;
    private String Description;
    private String Detail;
    private String Key;

    public viewcup() {
    }

    public viewcup(String header, String image, String description, String detail, String key) {
        this.Header = header;
        this.Image = image;
        this.Description = description;
        this.Detail = detail;
        this.Key = key;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
