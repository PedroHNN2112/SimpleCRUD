package com.pedrohenrique.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pessoas","postgres","root");
    }

    public static void closeConnection(Connection c) throws SQLException {
        if(c != null){
            c.close();
        }
    }
}
