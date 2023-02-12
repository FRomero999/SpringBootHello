/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootHello.services;

import com.example.SpringBootHello.repositories.AlumnoRepository;
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
    
}
