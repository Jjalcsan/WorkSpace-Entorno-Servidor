package com.ejemplo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.demo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
