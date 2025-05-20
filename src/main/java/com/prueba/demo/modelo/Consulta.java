package com.prueba.demo.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date fecha;
    private String hora;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    // Getters
    public Long getId() { return id; }
    public Date getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getMotivo() { return motivo; }
    public String getDiagnostico() { return diagnostico; }
    public String getTratamiento() { return tratamiento; }
    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }

    // Setters (importantes para la actualización)
    public void setId(Long id) { this.id = id; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public void setHora(String hora) { this.hora = hora; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public void setMedico(Medico medico) { this.medico = medico; }
}