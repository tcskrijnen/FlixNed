package com.flixned.streamingservice.common.models;

import javax.persistence.*;

@Entity
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String contentId;

    @Column(nullable = false, unique = true)
    private String url;

    public Stream() {
    }

    public Stream(String contentId, String url){
        this.contentId = contentId;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
