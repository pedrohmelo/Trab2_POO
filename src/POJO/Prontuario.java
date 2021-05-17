package POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdProntuario;
    private String sintomas;
    private String diagDoenca;
    private String prescTratamento;
    @OneToOne
    private Paciente paciente;
    
    public int getIdProntuario() {
        return IdProntuario;
    }

    public void setIdProntuario(int IdProntuario) {
        this.IdProntuario = IdProntuario;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagDoenca() {
        return diagDoenca;
    }

    public void setDiagDoenca(String diagDoenca) {
        this.diagDoenca = diagDoenca;
    }

    public String getPrescTratamento() {
        return prescTratamento;
    }

    public void setPrescTratamento(String prescTratamento) {
        this.prescTratamento = prescTratamento;
    }    
}
