package com.common.common.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private int episode;

    @Column(nullable = false, unique = true)
    private String season;

    @Column(nullable = true)
    private Date duration;

    @ElementCollection
    private List<String> cast = new ArrayList<String>();

    @Column(nullable = false, unique = true)
    private int year;
}
