package com.flixned.contentservice.common.models;

import javax.persistence.*;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String UserId;

    @Column(nullable = false, unique = true)
    private int contentId;
}
