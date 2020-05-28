package com.flixned.contentservice.controllers;

import com.flixned.contentservice.services.ContentService;
import org.springframework.stereotype.Controller;

@Controller
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }
}
