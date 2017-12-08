package controle;

import imobiliaria.dao.TipoDAO;
import imobiliaria.dao.ImovelDAO;
import imobiliaria.controle.entidade.Imovel;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistroControle {

    public void gravar(Imovel i) throws SQLException {
        ImovelDAO dao = new ImovelDAO();
        try {
            if (i.getId() == null || i.getId() <= 0) {
                dao.adicionar(i);
            } else {
                dao.alterar(i);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar as informações: \n" + ex.getMessage());

        }
    }

    public void excluir(Imovel i) throws SQLException {
        if (JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este imovel?") == JOptionPane.YES_OPTION) {
            ImovelDAO dao = new ImovelDAO();
            dao.excluir(i);
        }

    }

    public void excluir(Long id) throws SQLException {
        if (JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este imovel?") == JOptionPane.YES_OPTION) {
            ImovelDAO dao = new ImovelDAO();
            dao.excluir(id);
        }
    }

    public void atualizarLista(JTable tabela) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
//        limpa as linhas da tabela.
//        for(int i=0; i<model.getRowCount(); i++)
//            model.removeRow(i);
        //Limpar Listagem Tabela (YAN, 2017)
        model.setNumRows(0);

        ImovelDAO dao = new ImovelDAO();
        List imoveis = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : imoveis) {
            Imovel r = converte((Imovel) o);
            model.addRow(new Object[]{r.getId(), r.getNome(), r.getDescricao(), r.getArea(), r.getTotal(), r.getTipo()});
        }
    }

    private Imovel converte(Imovel r) {
        Imovel imovel = new Imovel();
        imovel.setId(r.getId());
        imovel.setNome(r.getNome());
        imovel.setDescricao(r.getDescricao());
        imovel.setArea(r.getArea());
        imovel.setTotal(r.getTotal());
        imovel.setTipo(r.getTipo());

        return imovel;
    }

    public Imovel getImovelPorId(Long id) throws SQLException {
        ImovelDAO dao = new ImovelDAO();
        Imovel r = converte((Imovel) dao.listarPorId(id));
        return r;
    }

    public List listarCategorias() throws SQLException {
        TipoDAO dao = new TipoDAO();
        return dao.listarTodos();
    }

}
