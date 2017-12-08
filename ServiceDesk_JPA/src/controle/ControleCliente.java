package controle;

import controle.entidade.Cliente;
import dao.DAOCliente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControleCliente {
    public void gravar(Cliente c)throws SQLException{
        DAOCliente dao = new DAOCliente();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Cliente c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")==JOptionPane.YES_OPTION){
            DAOCliente dao = new DAOCliente();    
            dao.excluir(c);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")==JOptionPane.YES_OPTION){
            DAOCliente dao = new DAOCliente();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        model.setNumRows(0);
        
        DAOCliente dao = new DAOCliente();
        List clientes = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : clientes){
            Cliente t = converte((controle.entidade.Cliente) o);
            model.addRow(new Object[]{t.getId(),t.getEmpresa(),t.getEndereco(), t.getContato()});
        }
        
    }
    private Cliente converte(controle.entidade.Cliente c){
        Cliente tipo = new Cliente();
        tipo.setId(c.getId());
        tipo.setEmpresa(c.getEmpresa());
        tipo.setEndereco(c.getEndereco());
        tipo.setContato(c.getContato());
        
        return tipo;
    }
    public Cliente getClientePorId(Long id) throws SQLException {
        DAOCliente dao = new DAOCliente();
        Cliente t = converte((controle.entidade.Cliente)dao.listarPorId(id));
        return t;       
    }    
}
