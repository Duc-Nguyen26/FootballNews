package com.example.footballnews.model;

import java.io.Serializable;

public class viewVN implements Serializable {
    private String Header;
    private String Image;
    private String Description;
    private String Detail;
    private String Key;
    public viewVN() {
    }
    public viewVN(String key) {
        Key = key;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
       this.Key = key;
    }



    public viewVN(String header, String image, String description, String detail) {
        this.Header = header;
        this.Image = image;
        this.Description = description;
        this.Detail = detail;
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
}
