package controle;

import controle.entidade.Proposta;
import dao.DAOProposta;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControleProposta {
    public void gravar(Proposta c)throws SQLException{
        DAOProposta dao = new DAOProposta();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Proposta c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")==JOptionPane.YES_OPTION){
            DAOProposta dao = new DAOProposta();    
            dao.excluir(c);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")==JOptionPane.YES_OPTION){
            DAOProposta dao = new DAOProposta();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        model.setNumRows(0);
        
        DAOProposta dao = new DAOProposta();
        List propostas = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : propostas){
            Proposta t = converte((controle.entidade.Proposta) o);
            model.addRow(new Object[]{t.getId(),t.getNome(),t.getEndereco(), t.getContato(), t.getDescricao()});
        }
        
    }
    private Proposta converte(controle.entidade.Proposta c){
        Proposta tipo = new Proposta();
        tipo.setId(c.getId());
        tipo.setNome(c.getNome());
        tipo.setEndereco(c.getEndereco());
        tipo.setContato(c.getContato());
        tipo.setDescricao(c.getDescricao());
        
        return tipo;
    }
    public Proposta getPropostaPorId(Long id) throws SQLException {
        DAOProposta dao = new DAOProposta();
        Proposta t = converte((controle.entidade.Proposta)dao.listarPorId(id));
        return t;       
    }        
}
