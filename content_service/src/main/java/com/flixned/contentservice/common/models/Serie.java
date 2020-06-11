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

    @Column()
    private String description;

    @Column()
    private String episodeName;

    @Column()
    private int episode;

    @Column()
    private int season;

    @Column()
    private int year;

    @Column()
    private Long duration;

    @ElementCollection
    private List<String> cast = new ArrayList<String>();

    @Column()
    private String imageUrl;

    public Serie(String serieId, String title, String description, String episodeName, int episode, int season,
                 int year, Long duration, List<String> cast, String imageUrl) {
        this.serieId = serieId;
        this.title = title;
        this.description = description;
        this.episodeName = episodeName;
        this.episode = episode;
        this.season = season;
        this.year = year;
        this.duration = duration;
        this.cast = cast;
        this.imageUrl = imageUrl;
    }

    public Serie() {
    }

    public Long getId() {
        return id;
    }

    public String getSerieId() {
        return serieId;
    }

    public void setSerieId(String serieId) {
        this.serieId = serieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
