package com.flixned.contentservice.common.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serieId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String episodeName;

    @Column(nullable = false)
    private int episode;

    @Column(nullable = false)
    private int season;

    @Column(nullable = false)
    private int year;

    @Column(nullable = true)
    private Long duration;

    @ElementCollection
    private List<String> cast = new ArrayList<String>();

    public Serie(String serieId, String title, String episodeName, int episode, int season, int year, Long duration, List<String> cast) {
        this.serieId = serieId;
        this.title = title;
        this.episodeName = episodeName;
        this.episode = episode;
        this.season = season;
        this.year = year;
        this.duration = duration;
        this.cast = cast;
    }

    public Serie() {
    }

    public Long getId() {
        return id;
    }

    public String getSerieId() {
        return serieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }
}
