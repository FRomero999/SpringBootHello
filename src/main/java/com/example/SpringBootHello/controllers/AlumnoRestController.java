/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootHello.controllers;

import com.example.SpringBootHello.repositories.AlumnoRepository;
import com.example.SpringBootHello.repositories.CursoRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import models.Alumno;
import models.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author frome
 */
@RestController
@RequestMapping("/clase")
public class AlumnoRestController {
    
    @Autowired
    AlumnoRepository repo;
    
    @Autowired
    CursoRepository repoCurso;

    @GetMapping()
    public List<Alumno> list() {
        return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> get(@PathVariable Long id) {
        
        ResponseEntity<Alumno> salida;
        
        if(repo.existsById(id)){
            Optional<Alumno> al = repo.findById(id);
            salida = new ResponseEntity<Alumno>(al.get(),HttpStatus.OK);
        }else{
            salida = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }
            
        return salida;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Alumno> put(@PathVariable Long id, @RequestBody Alumno input) {

        ResponseEntity<Alumno> salida;
        
        if(repo.existsById(id)){
            repo.save(input);            
            salida = new ResponseEntity<Alumno>(input,HttpStatus.OK);
        }else{
            salida = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }
            
        return salida;
    }
    
    @GetMapping("/curso/{curso}")
    public ResponseEntity<Curso> getCurso(@PathVariable String curso) {
        Curso c = repoCurso.findByNombre(curso).get();
        System.out.println( c );
       
        return new ResponseEntity<Curso>(c,HttpStatus.OK);
    }
    
    @PostMapping("/curso/{curso}")
    public ResponseEntity<Alumno> post(@PathVariable String curso,@RequestBody Alumno input) {
        Curso c = repoCurso.findByNombre(curso).get();
        System.out.println( c );

        c.getAlumnos().add(input);
        input.setCurso(c);
        repo.save(input);
       
        return new ResponseEntity<Alumno>(input,HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Alumno> postInCurso(@RequestBody Alumno input) {
        repo.save(input);
        return new ResponseEntity<Alumno>(input,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Alumno> delete(@PathVariable Long id) {
        ResponseEntity<Alumno> salida;
        
        if(repo.existsById(id)){
            salida = new ResponseEntity<Alumno>(repo.findById(id).get(),HttpStatus.OK);
            repo.deleteById(id);
        }else{
            salida = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }
            
        return salida;
    }
    
}
