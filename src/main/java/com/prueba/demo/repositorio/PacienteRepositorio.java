package com.prueba.demo.repositorio;

import com.prueba.demo.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {


}
