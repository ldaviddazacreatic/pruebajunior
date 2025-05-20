package com.prueba.demo.servicio;

import com.prueba.demo.modelo.Consulta;
import com.prueba.demo.repositorio.ConsultaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServicio {

    private final ConsultaRepositorio consultaRepositorio;

    public ConsultaServicio(ConsultaRepositorio consultaRepositorio) {
        this.consultaRepositorio = consultaRepositorio;
    }

    public List<Consulta> listar() {
        return consultaRepositorio.findAll();
    }

    public Optional<Consulta> obtenerPorId(Long id) {
        return consultaRepositorio.findById(id);
    }

    public Consulta guardar(Consulta consulta) {
        return consultaRepositorio.save(consulta);
    }

    public void eliminar(Long id) {
        consultaRepositorio.deleteById(id);
    }
}