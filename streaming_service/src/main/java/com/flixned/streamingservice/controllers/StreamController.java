package com.flixned.streamingservice.controllers;

import com.flixned.streamingservice.common.models.Stream;
import com.flixned.streamingservice.services.StreamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StreamController {

    private final StreamService streamService;

    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }

    @RequestMapping(value = RestURIConstant.allStreams, method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Stream> allStreams() {
        return streamService.allStreams();
    }

    @RequestMapping(value = RestURIConstant.getStream, method = RequestMethod.GET)
    public @ResponseBody
    Stream getStream(@RequestParam("contentId") String contentId) {
        return streamService.getStream(contentId);
    }
}
