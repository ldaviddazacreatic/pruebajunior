package com.prueba.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String especialidad;
    private String correo;
    private String telefono;

    // Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }

    // Setters (importantes para la actualización)
    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}