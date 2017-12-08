package dao;

import controle.entidade.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class DAOCategoria implements IDAO {

    @Override
    public void adicionar(Object o) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();

            em.getTransaction().begin();
            Categoria c = (Categoria) o;
            controle.entidade.Categoria entidade = new controle.entidade.Categoria();

            entidade.setNome(c.getNome());
            entidade.setDescricao(c.getDescricao());

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
            Categoria c = (Categoria) o;
            em.getTransaction().begin();
            controle.entidade.Categoria entidade = em.find(controle.entidade.Categoria.class, c.getId());
            entidade.setNome(c.getNome());
            entidade.setDescricao(c.getDescricao());

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
            Categoria t = (Categoria) o;
            em.getTransaction().begin();
            controle.entidade.Categoria entidade = em.find(controle.entidade.Categoria.class, t.getId());
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
            TypedQuery<controle.entidade.Categoria> query = em.createQuery("SELECT t FROM Categoria t", controle.entidade.Categoria.class);
            List<controle.entidade.Categoria> lista = query.getResultList();
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
            controle.entidade.Categoria t = em.find(controle.entidade.Categoria.class, id);

            em.close();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
