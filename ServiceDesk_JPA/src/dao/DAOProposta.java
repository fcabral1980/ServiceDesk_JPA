package dao;

import controle.entidade.Proposta;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class DAOProposta implements IDAO {

    @Override
    public void adicionar(Object o) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();

            em.getTransaction().begin();
            Proposta a = (Proposta) o;
            controle.entidade.Proposta entidade = new controle.entidade.Proposta();

            entidade.setNome(a.getNome());
            entidade.setEndereco(a.getEndereco());
            entidade.setContato(a.getContato());
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
            Proposta a = (Proposta) o;
            em.getTransaction().begin();
            controle.entidade.Proposta entidade = em.find(controle.entidade.Proposta.class, a.getId());

            entidade.setNome(a.getNome());
            entidade.setEndereco(a.getEndereco());
            entidade.setContato(a.getContato());
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
            Proposta a = (Proposta) o;
            em.getTransaction().begin();
            controle.entidade.Proposta entidade = em.find(controle.entidade.Proposta.class, a.getId());

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
            TypedQuery<controle.entidade.Proposta> query = em.createQuery("SELECT p FROM Proposta p", controle.entidade.Proposta.class);
            List<controle.entidade.Proposta> lista = query.getResultList();
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
            controle.entidade.Proposta a = em.find(controle.entidade.Proposta.class, id);

            em.close();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
