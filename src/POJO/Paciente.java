package POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdPaciente;
    private String nome;
    private String RG;
    private String endereco;
    private String tipoConvenio;
    private String telefone;
    private String email;
    @OneToOne
    private DadosMedico dadosMedico;
    @OneToOne
    private Prontuario prontuario;
    @OneToOne
    private Consulta consulta;
    
    
    public int getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(int IdPaciente) {
        this.IdPaciente = IdPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getRG(){
        return RG;
    }
    
    public void setRG(String RG){
        this.RG = RG;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(String tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
