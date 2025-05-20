package com.prueba.demo.servicio;

import com.prueba.demo.modelo.Medico;
import com.prueba.demo.repositorio.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServicio {

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    public List<Medico> obtenerTodos() {
        return medicoRepositorio.findAll();
    }

    public Optional<Medico> obtenerPorId(Long id) {
        return medicoRepositorio.findById(id);
    }

    public Medico guardar(Medico medico) {
        return medicoRepositorio.save(medico);
    }

    public Medico actualizar(Long id, Medico medicoActualizado) {
        return medicoRepositorio.findById(id)
                .map(medico -> {
                    medico.setNombre(medicoActualizado.getNombre());
                    medico.setEspecialidad(medicoActualizado.getEspecialidad());
                    medico.setCorreo(medicoActualizado.getCorreo());
                    medico.setTelefono(medicoActualizado.getTelefono());
                    return medicoRepositorio.save(medico);
                })
                .orElseGet(() -> {
                    medicoActualizado.setId(id);
                    return medicoRepositorio.save(medicoActualizado);
                });
    }

    public void eliminar(Long id) {
        medicoRepositorio.deleteById(id);
    }
}