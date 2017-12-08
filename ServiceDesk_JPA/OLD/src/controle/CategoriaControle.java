package controle;

import imobiliaria.dao.TipoDAO;
import imobiliaria.controle.entidade.Tipo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CategoriaControle{
    public void gravar(Tipo c)throws SQLException{
        TipoDAO dao = new TipoDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Tipo c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este tipo de imovel?")==JOptionPane.YES_OPTION){
            TipoDAO dao = new TipoDAO();    
            dao.excluir(c);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este tipo de imovel?")==JOptionPane.YES_OPTION){
            TipoDAO dao = new TipoDAO();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
//        for(int i=0; i<model.getRowCount(); i++){
//            model.removeRow(i);           
//        }
        //Limpar Listagem Tabela (YAN, 2017)
        model.setNumRows(0);
        
        TipoDAO dao = new TipoDAO();
        List tipos = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : tipos){
            Tipo t = converte((imobiliaria.controle.entidade.Tipo) o);
            model.addRow(new Object[]{t.getId(),t.getNome(),t.getDescricao()});
        }
        
    }
    private Tipo converte(imobiliaria.controle.entidade.Tipo c){
        Tipo tipo = new Tipo();
        tipo.setId(c.getId());
        tipo.setNome(c.getNome());
        tipo.setDescricao(c.getDescricao());
        
        return tipo;
    }
    public Tipo getTipoPorId(Long id) throws SQLException {
        TipoDAO dao = new TipoDAO();
        Tipo t = converte((imobiliaria.controle.entidade.Tipo)dao.listarPorId(id));
        return t;       
    }
}
