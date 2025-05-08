package com.prueba.demo.servicio;

import com.prueba.demo.modelo.Paciente;
import com.prueba.demo.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServicio {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    public List <Paciente> Listar (){
        return pacienteRepositorio.findAll();
    }

    public Paciente obtenerPorid(Long id){
        return pacienteRepositorio.findById(id).orElse(null);
    }

    public Paciente guardar(Paciente paciente){
        return pacienteRepositorio.save(paciente);
    }

    public void eliminar(Long id){
        pacienteRepositorio.deleteById(id);
    }


}
