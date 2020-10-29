package com.example.footballnews.model;

import java.io.Serializable;

public class viewRelated implements Serializable {
    private String Header;
    private String Description;
    private String Detail;
    private String Image;
    private String Source;
    private String Time;
    private String League;
    private String Key;

    public viewRelated() {
    }

    public viewRelated(String key) {
        this.Key = key;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public viewRelated(String header, String description, String detail, String image, String source, String time, String league) {
        this.Header = header;
        this.Description = description;
        this.Detail = detail;
        this.Image = image;
        this.Source = source;
        this.Time = time;
        this.League = league;
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

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }
}
