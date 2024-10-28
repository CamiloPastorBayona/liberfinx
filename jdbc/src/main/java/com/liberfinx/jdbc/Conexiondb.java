package com.liberfinx.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiondb {
        private static String url = "jdbc:mysql://localhost:3306/liberfinx";
        private static String user = "root";
        private static String pass = "123456";
        private static Connection con = null;

        public static Connection GetConexion()
        {
            if (con == null) {
                try
                {
                    con = DriverManager.getConnection(url, user, pass);
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

            return con;
        }
}
