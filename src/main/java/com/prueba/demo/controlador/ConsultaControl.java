package com.prueba.demo.controlador;

import com.prueba.demo.modelo.Consulta;
import com.prueba.demo.servicio.ConsultaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")

public class ConsultaControl {
    
private final ConsultaServicio service;

    public ConsultaControl(ConsultaServicio service) {
        this.service = service;
    }

    @GetMapping
    public List<Consulta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Consulta> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Consulta crear(@RequestBody Consulta consulta) {
        return service.guardar(consulta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}