package com.flixned.contentservice.repositories;

import com.flixned.contentservice.common.models.Serie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Long> {

}
