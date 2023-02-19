/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootHello.services;

import com.example.SpringBootHello.repositories.AlumnoRepository;
import com.example.SpringBootHello.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author frome
 */
@Service
public class appService {
    
    @Autowired
    AlumnoRepository repo;
    @Autowired
    CursoRepository cursos;
 
    public Integer cantidadAlumnos(String curso){
        return cursos.findByNombre(curso).get().getAlumnos().size();
    }
}
