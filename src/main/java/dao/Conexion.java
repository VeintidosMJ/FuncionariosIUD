package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

//CONECTARSE A LA BASE DE DATOS
public class Conexion {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/Funcionario_BD";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";
    
    //método de conexión
    public static Connection getConnection() throws SQLException{
           return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
