package com.prueba.demo.repositorio;

import com.prueba.demo.modelo.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepositorio extends JpaRepository<Medico, Long> {
}