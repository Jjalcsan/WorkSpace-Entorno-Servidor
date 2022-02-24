package com.ejemplo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.demo.model.Country;

public interface CountryRepo extends JpaRepository<Country, Integer>{

}
