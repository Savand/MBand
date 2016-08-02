package com.andsav.gk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andsav.gk.entities.Musician;

public interface MusicianRepository extends JpaRepository<Musician, Long>{

}
