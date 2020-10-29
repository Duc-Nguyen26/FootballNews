package com.example.footballnews.model;

import java.io.Serializable;

public class viewsearch implements Serializable {
    private String Header;
    private String Detail;
    private String Desciption;
    private String Source;
    private String Time;
    private String Picture;
    private String League;

    public viewsearch() {
    }

    public viewsearch(String header, String detail, String desciption, String source, String time, String picture, String league) {
        this.Header = header;
        this.Detail = detail;
        this.Desciption = desciption;
        this.Source = source;
        this.Time = time;
        this.Picture = picture;
        this.League = league;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getDesciption() {
        return Desciption;
    }

    public void setDesciption(String desciption) {
        Desciption = desciption;
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

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }
}
