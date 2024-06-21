package com.example.demojpalab.libros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demojpalab.libros.domain.Libro;

public interface LibroPersistence extends JpaRepository<Libro, Long> {

}
