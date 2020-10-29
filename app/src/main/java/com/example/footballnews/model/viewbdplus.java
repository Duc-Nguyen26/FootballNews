package com.example.footballnews.model;

import java.io.Serializable;

public class viewbdplus implements Serializable {
    private String Image;
    private String Header;
    private String Description;
    private String Key;
    private String Detail;

    public viewbdplus() {
    }

    public viewbdplus(String image, String header, String description, String key, String detail) {
        this.Image = image;
        this.Header = header;
        this.Description = description;
        this.Key = key;
        this.Detail = detail;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }
}
