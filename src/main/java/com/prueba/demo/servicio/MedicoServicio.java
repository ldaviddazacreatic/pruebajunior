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

    public void eliminar(Long id) {
        medicoRepositorio.deleteById(id);
    }
}
