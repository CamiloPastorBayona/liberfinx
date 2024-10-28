package com.liberfinx.jdbc.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiondb {
        private static String url = "jdbc:mysql://localhost:3306/liberfinx";
        private static String user = "root";
        private static String pass = "123456";
        private static Connection con = null;

    public static Connection GetConexion() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
