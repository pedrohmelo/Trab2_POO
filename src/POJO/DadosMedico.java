package POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class DadosMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdDadosAdicionais;
    private boolean fuma;
    private boolean bebe;
    private double colesterol;
    private String diabetes;
    private boolean doencaCardiaca;
    private String cirurgias;
    private String alergias;
    @OneToOne
    private Paciente paciente;
    
    public boolean getFuma(){
        return fuma;
    }

    public int getIdDadosAdicionais() {
        return IdDadosAdicionais;
    }

    public void setIdDadosAdicionais(int IdDadosAdicionais) {
        this.IdDadosAdicionais = IdDadosAdicionais;
    }
    
    public void setFuma(String fuma){
        if (fuma.equals("Sim")){
            this.fuma = true;
        }else if (fuma.equals("Não")){
            this.fuma = false;
        }
    }
       
    public boolean getBebe(){
        return bebe;
    }
    
    public void setBebe(String bebe){
        if (bebe.equals("Sim")){
            this.bebe = true;
        }else if (bebe.equals("Não")){
            this.bebe = false;
        }
    }
    
    public double getColesterol(){
        return colesterol;
    }
    
    public void setColesterol(String colesterol){
        try {
        this.colesterol = Double.parseDouble(colesterol);
        }catch(Exception e) {
           System.out.println("\nDados inválidos. Operação não foi realizada.");
        }
    }
    
    public String getDiabetes(){
        return diabetes;
    }
    
    public void setDiabetes(String diabetes){
        this.diabetes = diabetes;
    }
    
    public boolean getDoencaCardiaca(){
        return doencaCardiaca;
    }
    
    public void setDoencaCardiaca(String doencaCardiaca){
        if (doencaCardiaca.equals("Sim")){
            this.doencaCardiaca = true;
        }else if (doencaCardiaca.equals("Não")){
            this.doencaCardiaca = false;
        }
    }
    
    public String getCirurgias(){
        return cirurgias;
    }
    
    public void setCirurgias(String cirurgias){
        this.cirurgias = cirurgias;
    }
    
    public String getAlergias(){
        return alergias;
    }
    
    public void setAlergias(String alergias){
        this.alergias = alergias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}