package com.freshapples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshapples.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
}