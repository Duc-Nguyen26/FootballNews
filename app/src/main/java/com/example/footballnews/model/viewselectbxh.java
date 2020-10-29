package com.example.footballnews.model;

import java.io.Serializable;

public class viewselectbxh implements Serializable {
    private String Image;

    public viewselectbxh() {
    }

    public viewselectbxh(String image) {
        this.Image = image;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
