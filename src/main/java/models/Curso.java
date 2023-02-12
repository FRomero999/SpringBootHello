/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author frome
 */
@Data
@Entity
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private String nombre;
    
    @OneToMany( mappedBy = "curso", cascade=CascadeType.ALL)
    // cuando serializo a json, no incluro la propiedad curso en los alumnos
    @JsonIgnoreProperties(value = {"curso"})

    private List<Alumno> alumnos;
}
