package com.prueba.demo.controlador;

import com.prueba.demo.modelo.Consulta;
import com.prueba.demo.servicio.ConsultaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/consultas")
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
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        Optional<Consulta> consulta = service.obtenerPorId(id);
        if (consulta.isPresent()) {
            return ResponseEntity.ok(consulta.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Consulta con id " + id + " no encontrada");
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Consulta consulta) {
        try {
            Consulta nuevaConsulta = service.guardar(consulta);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaConsulta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar la consulta: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Consulta consultaActualizada) {
        try {
            Optional<Consulta> consultaExistente = service.obtenerPorId(id);
            
            if (consultaExistente.isPresent()) {
                Consulta consulta = consultaExistente.get();
                // Actualiza los campos necesarios
                consulta.setFecha(consultaActualizada.getFecha());
                consulta.setHora(consultaActualizada.getHora());
                consulta.setMotivo(consultaActualizada.getMotivo());
                consulta.setDiagnostico(consultaActualizada.getDiagnostico());
                consulta.setTratamiento(consultaActualizada.getTratamiento());
                // Actualiza las relaciones si es necesario
                consulta.setPaciente(consultaActualizada.getPaciente());
                consulta.setMedico(consultaActualizada.getMedico());
                
                Consulta consultaActualizadaDB = service.guardar(consulta);
                return ResponseEntity.ok(consultaActualizadaDB);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Consulta con id " + id + " no encontrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar la consulta: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok("Consulta eliminada con id " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la consulta: " + e.getMessage());
        }
    }
}