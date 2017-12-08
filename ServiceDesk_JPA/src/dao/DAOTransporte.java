package dao;

import controle.entidade.Transporte;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class DAOTransporte implements IDAO{
    
        @Override
    public void adicionar(Object o) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();

            em.getTransaction().begin();
            Transporte a = (Transporte) o;
            controle.entidade.Transporte entidade = new controle.entidade.Transporte();

            entidade.setTransporte(a.getTransporte());
            entidade.setDescricao(a.getDescricao());
            
            em.persist(entidade);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterar(Object o) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();
            Transporte a = (Transporte) o;
            em.getTransaction().begin();
            controle.entidade.Transporte entidade = em.find(controle.entidade.Transporte.class, a.getId());
            
            entidade.setTransporte(a.getTransporte());
            entidade.setDescricao(a.getDescricao());

            em.merge(entidade);

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Object o) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();

            EntityManager em = conn.createEntityManager();
            Transporte a = (Transporte) o;
            em.getTransaction().begin();
            controle.entidade.Transporte entidade = em.find(controle.entidade.Transporte.class, a.getId());
            
            em.remove(entidade);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Long id) throws SQLException {

    }

    @Override
    public List listarTodos() throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();
            TypedQuery<controle.entidade.Transporte> query = em.createQuery("SELECT t FROM Transporte t", controle.entidade.Transporte.class);
            List<controle.entidade.Transporte> lista = query.getResultList();
            em.close();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object listarPorId(Long id) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();
            controle.entidade.Transporte a = em.find(controle.entidade.Transporte.class, id);

            em.close();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
