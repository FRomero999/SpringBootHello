/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootHello.repositories;

import java.util.Optional;
import models.Curso;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author frome
 */
public interface CursoRepository extends CrudRepository<Curso, Long> {
    
    public Optional<Curso> findByNombre(String name);
    
}
