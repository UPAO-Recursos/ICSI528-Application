package com.example.demojpalab.libros.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpalab.libros.domain.Libro;
import com.example.demojpalab.libros.repository.LibroPersistence;

@RestController
@RequestMapping("libros")
public class LibrosController {
  @Autowired
  private LibroPersistence libros;

  @GetMapping()
  public List<Libro> getAll() {
    return libros.findAll();
  }

  @GetMapping("{id}")
  public Libro findById(@PathVariable Long id) {
    return libros.findById(id).orElse(null);
  }

  @PostMapping()
  public Libro save(@RequestBody Libro entity) {
    return libros.save(entity);
  }
}
