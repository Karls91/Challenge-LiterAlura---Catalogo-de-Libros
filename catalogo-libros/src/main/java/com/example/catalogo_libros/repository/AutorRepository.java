package com.example.catalogo_libros.repository;

import com.example.catalogo_libros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}