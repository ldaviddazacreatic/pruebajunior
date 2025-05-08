package com.prueba.demo.repositorio;

import com.prueba.demo.modelo.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepositorio extends JpaRepository<Consulta, Long> {
}
