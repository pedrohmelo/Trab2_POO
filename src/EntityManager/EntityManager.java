package EntityManager;

import POJO.Consulta;
import POJO.Paciente;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class EntityManager<Entity>{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaMedicaInterfacePU");
    EntityManager em = emf.createEntityManager();
    
    public int Insere(Entity entity) {
            try {
                em.getTransaction().begin();
                em.persist(entity);
                em.getTransaction().commit();
                return 1;
            } catch(Exception E) {
                em.getTransaction().rollback();
                System.out.println(E);
                return 0;
            }
        }
        
        public int Atualiza() {
            try {
                em.getTransaction().begin();
                em.getTransaction().commit();
                return 1;
            } catch(Exception E) {
                em.getTransaction().rollback();
                System.out.println(E);
                return 0;
            }
        }
        
        public int Remove(Entity entity) {
            try {
                em.getTransaction().begin();
                em.remove(entity);
                em.getTransaction().commit();
                return 1;
            } catch(Exception E) {
                em.getTransaction().rollback();
                System.out.println(E);
                return 0;
            }
        }
        
        public List<Paciente> getPacientes() {
            return em.createQuery("SELECT a FROM Paciente a", Paciente.class).getResultList();
        }
        
        public Paciente buscaPaciente(int IdPaciente) {
            return em.find(Paciente.class, IdPaciente);
        }
        public List<Paciente> buscaPacienteConsultas() {
            return em.createQuery("SELECT a FROM Paciente a WHERE a.consulta IS NOT NULL", Paciente.class).getResultList();
        }
                
        public List<Consulta> buscaConsultasAmanha(String str) {
            return em.createQuery("SELECT a FROM Consulta a WHERE " + str + "a.data = {d '" 
                    + LocalDate.now().plusDays(1).toString() 
                    + "'}", Consulta.class).getResultList();
        }
        
        public Consulta buscaConsulta(int id) {
            return em.createQuery("SELECT a FROM Consulta a WHERE a.idConsulta = :id", Consulta.class).setParameter("id", id).getSingleResult();
        }
        
        public int atualizaPaciente() {
            try {
                em.getTransaction().begin();
                em.getTransaction().commit();
                return 1;
            } catch(Exception E) {
                em.getTransaction().rollback();
                System.out.println(E);
                return 0;
            }
        }
        
        public void gerenciadorMsg() {
            String txt = "";
            List<Consulta> results = buscaConsultasAmanha("");
            Paciente p = new Paciente();
            for(int i = 0; i < results.size();i++) {
                p = results.get(i).getPaciente();
                if(p.getEmail().equals("") && !p.getTelefone().equals("")) {
                    txt += "A mensagem foi enviada para: ";
                } else if(!p.getEmail().equals("") && p.getTelefone().equals("")){
                    txt += "O email enviado para: ";
                } else if(!p.getEmail().equals("") && !p.getTelefone().equals("")) {
                    txt += "A mensagem e o email foram enviados para: ";
                } else {
                    txt += "Não há nenhum registro de contato para: ";
                }
                txt += p.getNome() + "\n";
            }
            JOptionPane.showMessageDialog(null, txt, "Gerenciador de mensagens", JOptionPane.INFORMATION_MESSAGE);
        }
}