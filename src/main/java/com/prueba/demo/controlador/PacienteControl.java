package com.prueba.demo.controlador;

import com.prueba.demo.modelo.Paciente;
import com.prueba.demo.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pacientes")

public class PacienteControl {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping
    public java.util.List<Paciente> listar(){
        return pacienteServicio.Listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtener(@PathVariable Long id){
        Paciente paciente = pacienteServicio.obtenerPorid(id);
        return paciente != null ? ResponseEntity.ok(paciente) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente){
        return pacienteServicio.guardar(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente paciente){
        if (pacienteServicio.obtenerPorid(id) == null) {
            return ResponseEntity.notFound().build();
        }
        paciente.setId(id);
        return ResponseEntity.ok(pacienteServicio.guardar(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if (pacienteServicio.obtenerPorid(id) == null) {
            return ResponseEntity.notFound().build();
        }
        pacienteServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }



}
