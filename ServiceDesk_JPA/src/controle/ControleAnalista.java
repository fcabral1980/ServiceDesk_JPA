package controle;

import controle.entidade.Analista;
import dao.DAOAnalista;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControleAnalista {
    public void gravar(Analista c)throws SQLException{
        DAOAnalista dao = new DAOAnalista();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Analista c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")==JOptionPane.YES_OPTION){
            DAOAnalista dao = new DAOAnalista();    
            dao.excluir(c);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")==JOptionPane.YES_OPTION){
            DAOAnalista dao = new DAOAnalista();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        model.setNumRows(0);
        
        DAOAnalista dao = new DAOAnalista();
        List analistas = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : analistas){
            Analista t = converte((controle.entidade.Analista) o);
            model.addRow(new Object[]{t.getId(),t.getNome(),t.getPerfil()});
        }
        
    }
    private Analista converte(controle.entidade.Analista c){
        Analista tipo = new Analista();
        tipo.setId(c.getId());
        tipo.setNome(c.getNome());
        tipo.setPerfil(c.getPerfil());
        
        return tipo;
    }
    public Analista getAnalistaPorId(Long id) throws SQLException {
        DAOAnalista dao = new DAOAnalista();
        Analista t = converte((controle.entidade.Analista)dao.listarPorId(id));
        return t;       
    }
}
