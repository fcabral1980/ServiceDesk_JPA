package dao;

import controle.entidade.Cliente;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class DAOCliente implements IDAO {

    @Override
    public void adicionar(Object o) throws SQLException {
        EntityManagerFactory conn = null;
        try {
            conn = FabricaConexao.getConexao();
            EntityManager em = conn.createEntityManager();

            em.getTransaction().begin();
            Cliente a = (Cliente) o;
            controle.entidade.Cliente entidade = new controle.entidade.Cliente();

            entidade.setEmpresa(a.getEmpresa());
            entidade.setEndereco(a.getEndereco());
            entidade.setContato(a.getContato());

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
            Cliente a = (Cliente) o;
            em.getTransaction().begin();
            controle.entidade.Cliente entidade = em.find(controle.entidade.Cliente.class, a.getId());
            
            entidade.setEmpresa(a.getEmpresa());
            entidade.setEndereco(a.getEndereco());
            entidade.setContato(a.getContato());

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
            Cliente a = (Cliente) o;
            em.getTransaction().begin();
            controle.entidade.Cliente entidade = em.find(controle.entidade.Cliente.class, a.getId());
            
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
            TypedQuery<controle.entidade.Cliente> query = em.createQuery("SELECT c FROM Cliente c", controle.entidade.Cliente.class);
            List<controle.entidade.Cliente> lista = query.getResultList();
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
            controle.entidade.Cliente a = em.find(controle.entidade.Cliente.class, id);

            em.close();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
