package dao;

import imobiliaria.controle.entidade.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class CategoriaDAO implements IDAO {

    @Override
    public void adicionar(Object o) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();

            em.getTransaction().begin();
            Tipo c = (Tipo) o;
            imobiliaria.controle.entidade.Tipo entidade = new imobiliaria.controle.entidade.Tipo();

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
            Tipo c = (Tipo) o;
            em.getTransaction().begin();
            imobiliaria.controle.entidade.Tipo tipo = em.find(imobiliaria.controle.entidade.Tipo.class, c.getId());
            tipo.setNome(c.getNome());
            tipo.setDescricao(c.getDescricao());

            em.merge(tipo);

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
            Tipo t = (Tipo) o;
            em.getTransaction().begin();
            imobiliaria.controle.entidade.Tipo tipo = em.find(imobiliaria.controle.entidade.Tipo.class, t.getId());
            em.remove(tipo);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Long id) throws SQLException {
//        
//        Connection conn = null;
//        try {
//            conn = FabricaConexao.getConexao();
//
//            String sql = "DELETE FROM public.categoria\n" +
//"	WHERE id = ?";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            // preenche os valores                     
//            stmt.setLong(1, id);
//            
//            stmt.executeUpdate();
//            stmt.close();
//            
//        } catch (SQLException e) {
//            throw new SQLException("Eroo ao tentar remover a categoria. \n" + e.getMessage());
//        }
    }

    @Override
    public List listarTodos() throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();
            TypedQuery<imobiliaria.controle.entidade.Tipo> query = em.createQuery("SELECT t FROM Tipo t", imobiliaria.controle.entidade.Tipo.class);
            List<imobiliaria.controle.entidade.Tipo> lista = query.getResultList();
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
            imobiliaria.controle.entidade.Tipo t = em.find(imobiliaria.controle.entidade.Tipo.class, id);

            em.close();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
