/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootHello.repositories;

import models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author frome
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
}
