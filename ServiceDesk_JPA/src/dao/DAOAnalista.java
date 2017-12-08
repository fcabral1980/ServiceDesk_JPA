package dao;

import controle.entidade.Analista;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class DAOAnalista implements IDAO {

    @Override
    public void adicionar(Object o) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();

            em.getTransaction().begin();
            Analista a = (Analista) o;
            controle.entidade.Analista entidade = new controle.entidade.Analista();

            entidade.setNome(a.getNome());
            entidade.setPerfil(a.getPerfil());

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
            Analista a = (Analista) o;
            em.getTransaction().begin();
            controle.entidade.Analista entidade = em.find(controle.entidade.Analista.class, a.getId());
            entidade.setNome(a.getNome());
            entidade.setPerfil(a.getPerfil());

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
            Analista a = (Analista) o;
            em.getTransaction().begin();
            controle.entidade.Analista entidade = em.find(controle.entidade.Analista.class, a.getId());
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
            TypedQuery<controle.entidade.Analista> query = em.createQuery("SELECT a FROM Analista a", controle.entidade.Analista.class);
            List<controle.entidade.Analista> lista = query.getResultList();
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
            controle.entidade.Analista a = em.find(controle.entidade.Analista.class, id);

            em.close();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
