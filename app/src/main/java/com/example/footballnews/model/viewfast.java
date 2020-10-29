package com.example.footballnews.model;

import java.io.Serializable;

public class viewfast implements Serializable {
    private String Image;
    private String Header;
    private String Description;
    private String Key;
    private String Detail;
    private String Time;
    private String Source;
    private String League;

    public viewfast() {
    }

    public viewfast(String image, String header, String description, String key, String detail, String time, String source, String league) {
        this.Image = image;
        this.Header = header;
        this.Description = description;
        this.Key = key;
        this.Detail = detail;
        this.Time = time;
        this.Source = source;
        this.League = league;
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

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }
}
