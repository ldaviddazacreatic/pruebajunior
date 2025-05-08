package com.prueba.demo.controlador;

import com.prueba.demo.modelo.Medico;
import com.prueba.demo.servicio.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicos")
public class MedicoControl {

    @Autowired
    private MedicoServicio medicoServicio;

    @GetMapping
    public List<Medico> obtenerTodos() {
        return medicoServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Medico> obtenerPorId(@PathVariable Long id) {
        return medicoServicio.obtenerPorId(id);
    }

    @PostMapping
    public Medico guardar(@RequestBody Medico medico) {
        return medicoServicio.guardar(medico);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        medicoServicio.eliminar(id);
    }
}
