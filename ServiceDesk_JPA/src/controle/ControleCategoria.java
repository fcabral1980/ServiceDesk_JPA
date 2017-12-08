package controle;

import dao.DAOCategoria;
import controle.entidade.Categoria;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ControleCategoria{
    public void gravar(Categoria c)throws SQLException{
        DAOCategoria dao = new DAOCategoria();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Categoria c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")==JOptionPane.YES_OPTION){
            DAOCategoria dao = new DAOCategoria();    
            dao.excluir(c);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")==JOptionPane.YES_OPTION){
            DAOCategoria dao = new DAOCategoria();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        model.setNumRows(0);
        
        DAOCategoria dao = new DAOCategoria();
        List categorias = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : categorias){
            Categoria t = converte((controle.entidade.Categoria) o);
            model.addRow(new Object[]{t.getId(),t.getNome(),t.getDescricao()});
        }
        
    }
    private Categoria converte(controle.entidade.Categoria c){
        Categoria tipo = new Categoria();
        tipo.setId(c.getId());
        tipo.setNome(c.getNome());
        tipo.setDescricao(c.getDescricao());
        
        return tipo;
    }
    public Categoria getCategoriaPorId(Long id) throws SQLException {
        DAOCategoria dao = new DAOCategoria();
        Categoria t = converte((controle.entidade.Categoria)dao.listarPorId(id));
        return t;       
    }
}
