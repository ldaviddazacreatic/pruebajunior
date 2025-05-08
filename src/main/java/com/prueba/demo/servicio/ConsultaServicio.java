package com.prueba.demo.servicio;

import com.prueba.demo.modelo.Consulta;
import com.prueba.demo.repositorio.ConsultaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ConsultaServicio {
    
private final ConsultaRepositorio repository;

    public ConsultaServicio(ConsultaRepositorio repository) {
        this.repository = repository;
    }

    public List<Consulta> listar() {
        return repository.findAll();
    }

    public Optional<Consulta> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Consulta guardar(Consulta consulta) {
        return repository.save(consulta);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}