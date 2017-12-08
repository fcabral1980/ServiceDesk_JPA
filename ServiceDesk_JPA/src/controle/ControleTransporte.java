package controle;

import controle.entidade.Transporte;
import dao.DAOTransporte;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControleTransporte {
    public void gravar(Transporte c)throws SQLException{
        DAOTransporte dao = new DAOTransporte();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Transporte c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")==JOptionPane.YES_OPTION){
            DAOTransporte dao = new DAOTransporte();    
            dao.excluir(c);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")==JOptionPane.YES_OPTION){
            DAOTransporte dao = new DAOTransporte();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        model.setNumRows(0);
        
        DAOTransporte dao = new DAOTransporte();
        List transportes = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : transportes){
            Transporte t = converte((controle.entidade.Transporte) o);
            model.addRow(new Object[]{t.getId(),t.getTransporte(),t.getDescricao()});
        }
        
    }
    private Transporte converte(controle.entidade.Transporte c){
        Transporte tipo = new Transporte();
        tipo.setId(c.getId());
        tipo.setTransporte(c.getTransporte());
        tipo.setDescricao(c.getDescricao());        
        
        return tipo;
    }
    public Transporte getTransportePorId(Long id) throws SQLException {
        DAOTransporte dao = new DAOTransporte();
        Transporte t = converte((controle.entidade.Transporte)dao.listarPorId(id));
        return t;       
    }      
}
