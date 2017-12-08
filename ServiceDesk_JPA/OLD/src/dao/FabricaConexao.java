package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaConexao {

    private static Connection conn;

    public static EntityManagerFactory getConexao() throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        return emf;
    }
}
