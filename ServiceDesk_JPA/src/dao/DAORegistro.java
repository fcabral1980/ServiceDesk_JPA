package dao;

import controle.entidade.Categoria;
import controle.entidade.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class DAORegistro implements IDAO {

    @Override
    public void adicionar(Object o) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();

            em.getTransaction().begin();
            Registro r = (Registro) o;
            Registro entidade = new Registro();

            entidade.setCliente(r.getCliente());
            entidade.setProblema(r.getProblema());
            entidade.setDescricao(r.getDescricao());
            entidade.setSolucao(r.getSolucao());
            entidade.setCategoria(r.getCategoria());
            entidade.setAnalista(r.getAnalista());
            entidade.setTransporte(r.getTransporte());

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
            Registro r = (Registro) o;
            em.getTransaction().begin();
            Registro entidade = em.find(Registro.class, r.getId());

            entidade.setCliente(r.getCliente());
            entidade.setProblema(r.getProblema());
            entidade.setDescricao(r.getDescricao());
            entidade.setSolucao(r.getSolucao());
            entidade.setCategoria(r.getCategoria());
            entidade.setAnalista(r.getAnalista());
            entidade.setTransporte(r.getTransporte());

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
            Registro r = (Registro) o;
            em.getTransaction().begin();
            Registro entidade = em.find(Registro.class, r.getId());
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
            TypedQuery<Registro> query = em.createQuery("SELECT r FROM Registro r", Registro.class);
            List<Registro> lista = query.getResultList();
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
            Registro r = em.find(Registro.class, id);
            em.close();
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void recuperarRegistro(Registro r) throws SQLException {

    }

}
