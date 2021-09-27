package br.com.alfashop.conex;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alfamidia
 */
public class MinhaConex 
{
    public static Connection getConnection() {
        Connection conn;
        //fazer a conexão com o banco
        try {
            //conectar com banco de dados
            Class.forName("com.mysql.jdbc.Driver"); 
            String host = "jdbc:mysql://localhost/alfashop";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(host, user, pass);
        }
        catch(Exception e) {
            conn = null;
        }
        
        return conn;
    }
}
