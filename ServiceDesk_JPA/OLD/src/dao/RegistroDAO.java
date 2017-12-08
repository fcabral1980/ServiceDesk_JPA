package dao;

import imobiliaria.controle.entidade.Tipo;
import imobiliaria.controle.entidade.Imovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class RegistroDAO implements IDAO {

    @Override
    public void adicionar(Object o) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();

            em.getTransaction().begin();
            Imovel r = (Imovel) o;
            Imovel entidade = new Imovel();

            entidade.setNome(r.getNome());
            entidade.setDescricao(r.getDescricao());
            entidade.setArea(r.getArea());
            entidade.setTotal(r.getTotal());
            entidade.setTipo(r.getTipo());

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
            Imovel r = (Imovel) o;
            em.getTransaction().begin();
            Imovel entidade = em.find(Imovel.class, r.getId());
            entidade.setNome(r.getNome());
            entidade.setDescricao(r.getDescricao());
            entidade.setArea(r.getArea());
            entidade.setTotal(r.getTotal());
            entidade.setTipo(r.getTipo());
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
            Imovel r = (Imovel) o;
            em.getTransaction().begin();
            Imovel entidade = em.find(Imovel.class, r.getId());
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
            TypedQuery<Imovel> query = em.createQuery("SELECT r FROM Imovel r", Imovel.class);
            List<Imovel> lista = query.getResultList();
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
            Imovel r = em.find(Imovel.class, id);
            em.close();
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void recuperarImoveis(Imovel r) throws SQLException {

    }

}
