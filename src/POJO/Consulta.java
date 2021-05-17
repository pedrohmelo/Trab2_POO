package POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class Consulta{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdConsulta;
    
    private String horario;
    private String medico;
    private String tipoConvenio;
    @OneToOne
    private Paciente paciente;
    
    public Consulta(){
        
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTipo() {
        return tipoConvenio;
    }

    public void setTipo(String tipo) {
        this.tipoConvenio = tipoConvenio;
    }

    public int getIdConsulta() {
        return IdConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.IdConsulta = IdConsulta;
    }
}