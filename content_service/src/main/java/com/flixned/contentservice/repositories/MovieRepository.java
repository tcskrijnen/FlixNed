package com.flixned.contentservice.repositories;

import com.flixned.contentservice.common.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Movie getMovieByMovieId(String movieId);
}
