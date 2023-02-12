/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;

/**
 *
 * @author frome
 */
@Data
@Entity
public class Alumno implements Serializable {
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    public Long id;
    
    private String nombre;
    private String apellidos;
    
    @ManyToOne
    @JoinColumn( name = "curso_id" )
    @ToString.Exclude
    @JsonIgnore
    private Curso curso;
    
    @Getter(AccessLevel.NONE)
    private String nombre_curso;

    public String getNombre_curso() {
        if(curso==null) return null;
        else return curso.getNombre();
    }
    
    
}