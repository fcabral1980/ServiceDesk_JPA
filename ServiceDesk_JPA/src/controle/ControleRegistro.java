package controle;

import dao.DAOCategoria;
import dao.DAORegistro;
import controle.entidade.Registro;
import dao.DAOAnalista;
import dao.DAOCliente;
import dao.DAOTransporte;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControleRegistro {

    public void gravar(Registro i) throws SQLException {
        DAORegistro dao = new DAORegistro();
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

    public void excluir(Registro i) throws SQLException {
        if (JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este registro?") == JOptionPane.YES_OPTION) {
            DAORegistro dao = new DAORegistro();
            dao.excluir(i);
        }

    }

    public void excluir(Long id) throws SQLException {
        if (JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este registro?") == JOptionPane.YES_OPTION) {
            DAORegistro dao = new DAORegistro();
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

        DAORegistro dao = new DAORegistro();
        List imoveis = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : imoveis) {
            Registro r = converte((Registro) o);
            model.addRow(new Object[]{r.getId(), r.getCliente(), r.getProblema(), r.getDescricao(), r.getSolucao(), r.getCategoria(), r.getAnalista(), r.getTransporte()});
        }
    }

    private Registro converte(Registro r) {
        Registro classe = new Registro();
        classe.setId(r.getId());
        classe.setCliente(r.getCliente());
        classe.setProblema(r.getProblema());
        classe.setDescricao(r.getDescricao());
        classe.setSolucao(r.getSolucao());
        classe.setCategoria(r.getCategoria());
        classe.setAnalista(r.getAnalista());
        classe.setTransporte(r.getTransporte());

        return classe;
    }

    public Registro getRegistroPorId(Long id) throws SQLException {
        DAORegistro dao = new DAORegistro();
        Registro r = converte((Registro) dao.listarPorId(id));
        return r;
    }

    public List listarCategorias() throws SQLException {
        DAOCategoria dao = new DAOCategoria();
        //REVISAR LISTAR TODOS
        return dao.listarTodos();
    }
    
    public List listarCliente() throws SQLException {
        DAOCliente dao = new DAOCliente();
        return dao.listarTodos();
    }
    
    public List listarAnalista() throws SQLException {
        DAOAnalista dao = new DAOAnalista();
        return dao.listarTodos();
    }
    
    public List listarTransporte() throws SQLException {
        DAOTransporte dao = new DAOTransporte();
        return dao.listarTodos();
    }

}
