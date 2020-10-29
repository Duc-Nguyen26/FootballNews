package com.example.footballnews.model;

import java.io.Serializable;

public class viewlichday implements Serializable {
    private  String Day;
    private String Half;
    private String League;
    private String Time;
    private String Stage;
    private String Team1;
    private String Team2;
    private String Name1;
    private String Name2;
    private String Score1;
    private String Score2;
    private String Key;

    public viewlichday() {
    }

    public viewlichday(String day, String half, String league, String time, String stage, String team1, String team2, String name1, String name2, String score1, String score2, String key) {
        this.Day = day;
        this.Half = half;
        this.League = league;
        this.Time = time;
        this.Stage = stage;
        this.Team1 = team1;
        this.Team2 = team2;
        this.Name1 = name1;
        this.Name2 = name2;
        this.Score1 = score1;
        this.Score2 = score2;
        this.Key = key;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getHalf() {
        return Half;
    }

    public void setHalf(String half) {
        Half = half;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getStage() {
        return Stage;
    }

    public void setStage(String stage) {
        Stage = stage;
    }

    public String getTeam1() {
        return Team1;
    }

    public void setTeam1(String team1) {
        Team1 = team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public void setTeam2(String team2) {
        Team2 = team2;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    public String getName2() {
        return Name2;
    }

    public void setName2(String name2) {
        Name2 = name2;
    }

    public String getScore1() {
        return Score1;
    }

    public void setScore1(String score1) {
        Score1 = score1;
    }

    public String getScore2() {
        return Score2;
    }

    public void setScore2(String score2) {
        Score2 = score2;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
