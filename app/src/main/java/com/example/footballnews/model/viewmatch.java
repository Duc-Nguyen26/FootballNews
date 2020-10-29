package com.example.footballnews.model;

import java.io.Serializable;

public class viewmatch implements Serializable {
    private String Score1;
    private String Score2;
    private String Time;
    private String Team1;
    private String Team2;
    private String Key;
    private String FTHT;
    private String Stage;
    private String Name1;
    private String Name2;
    private String League;
    private String Video;
    private String Round;
    private String Goal1;
    private String Goal2;
    private String ImageSumary;
    private String Source;
    private String Sumary1;
    private String Sumary2;
    private String Timesumary;
    private String Lineup1;
    private String Lineup2;
    private String ImageLineup1;
    private String ImageLineup2;
    private String Coach1;
    private String Coach2;
    private String Starting1;
    private String Starting2;
    private String Subition1;
    private String Subition2;
    private String Viewline1;
    private String Viewline2;
    private String url;

    public viewmatch() {
    }

    public viewmatch(String score1, String score2, String time, String team1, String team2, String key, String FTHT,
                     String stage, String name1, String name2, String league, String video, String round, String goal1,
                     String goal2, String imageSumary, String source, String sumary1, String sumary2, String timesumary,
                     String lineup1, String lineup2, String imageLineup1, String imageLineup2, String coach1, String coach2,
                     String starting1, String starting2, String subition1, String subition2, String viewline1,
                     String viewline2, String url) {
        this.Score1 = score1;
        this.Score2 = score2;
        this.Time = time;
        this.Team1 = team1;
        this.Team2 = team2;
        this.Key = key;
        this.FTHT = FTHT;
        this.Stage = stage;
        this.Name1 = name1;
        this.Name2 = name2;
        this.League = league;
        this.Video = video;
        this.Round = round;
        this.Goal1 = goal1;
        this.Goal2 = goal2;
        this.ImageSumary = imageSumary;
        this.Source = source;
        this.Sumary1 = sumary1;
        this.Sumary2 = sumary2;
        this.Timesumary = timesumary;
        this.Lineup1 = lineup1;
        this.Lineup2 = lineup2;
        this.ImageLineup1 = imageLineup1;
        this.ImageLineup2 = imageLineup2;
        this.Coach1 = coach1;
        this.Coach2 = coach2;
        this.Starting1 = starting1;
        this.Starting2 = starting2;
        this.Subition1 = subition1;
        this.Subition2 = subition2;
        this.Viewline1 = viewline1;
        this.Viewline2 = viewline2;
        this.url = url;
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

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
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

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getFTHT() {
        return FTHT;
    }

    public void setFTHT(String FTHT) {
        this.FTHT = FTHT;
    }

    public String getStage() {
        return Stage;
    }

    public void setStage(String stage) {
        Stage = stage;
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

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }

    public String getRound() {
        return Round;
    }

    public void setRound(String round) {
        Round = round;
    }

    public String getGoal1() {
        return Goal1;
    }

    public void setGoal1(String goal1) {
        Goal1 = goal1;
    }

    public String getGoal2() {
        return Goal2;
    }

    public void setGoal2(String goal2) {
        Goal2 = goal2;
    }

    public String getImageSumary() {
        return ImageSumary;
    }

    public void setImageSumary(String imageSumary) {
        ImageSumary = imageSumary;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getSumary1() {
        return Sumary1;
    }

    public void setSumary1(String sumary1) {
        Sumary1 = sumary1;
    }

    public String getSumary2() {
        return Sumary2;
    }

    public void setSumary2(String sumary2) {
        Sumary2 = sumary2;
    }

    public String getTimesumary() {
        return Timesumary;
    }

    public void setTimesumary(String timesumary) {
        Timesumary = timesumary;
    }

    public String getLineup1() {
        return Lineup1;
    }

    public void setLineup1(String lineup1) {
        Lineup1 = lineup1;
    }

    public String getLineup2() {
        return Lineup2;
    }

    public void setLineup2(String lineup2) {
        Lineup2 = lineup2;
    }

    public String getImageLineup1() {
        return ImageLineup1;
    }

    public void setImageLineup1(String imageLineup1) {
        ImageLineup1 = imageLineup1;
    }

    public String getImageLineup2() {
        return ImageLineup2;
    }

    public void setImageLineup2(String imageLineup2) {
        ImageLineup2 = imageLineup2;
    }

    public String getCoach1() {
        return Coach1;
    }

    public void setCoach1(String coach1) {
        Coach1 = coach1;
    }

    public String getCoach2() {
        return Coach2;
    }

    public void setCoach2(String coach2) {
        Coach2 = coach2;
    }

    public String getStarting1() {
        return Starting1;
    }

    public void setStarting1(String starting1) {
        Starting1 = starting1;
    }

    public String getStarting2() {
        return Starting2;
    }

    public void setStarting2(String starting2) {
        Starting2 = starting2;
    }

    public String getSubition1() {
        return Subition1;
    }

    public void setSubition1(String subition1) {
        Subition1 = subition1;
    }

    public String getSubition2() {
        return Subition2;
    }

    public void setSubition2(String subition2) {
        Subition2 = subition2;
    }

    public String getViewline1() {
        return Viewline1;
    }

    public void setViewline1(String viewline1) {
        Viewline1 = viewline1;
    }

    public String getViewline2() {
        return Viewline2;
    }

    public void setViewline2(String viewline2) {
        Viewline2 = viewline2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
