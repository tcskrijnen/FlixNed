package com.flixned.streamingservice.repositories;

import com.flixned.streamingservice.common.models.Stream;
import org.springframework.data.repository.CrudRepository;

public interface StreamRepository extends CrudRepository<Stream, Long> {

    Stream getStreamByContentId(String contentId);
}
