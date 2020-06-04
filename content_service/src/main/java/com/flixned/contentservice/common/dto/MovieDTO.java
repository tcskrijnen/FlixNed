package com.flixned.contentservice.common.dto;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {

    private String moveId;
    private String title;
    private Long duration;
    private List<String> cast = new ArrayList<String>();
    private int year;

    public MovieDTO(String moveId, String title, Long duration, List<String> cast, int year) {
        this.moveId = moveId;
        this.title = title;
        this.duration = duration;
        this.cast = cast;
        this.year = year;
    }
}
