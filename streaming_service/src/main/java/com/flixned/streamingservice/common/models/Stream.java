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
}
