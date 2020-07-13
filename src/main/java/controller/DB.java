package controller;

import model.car;

import java.sql.*;
import java.util.List;

public class DB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*String url = "jdbc:h2:~/test";
        String index = "index.jsp";
        Statement stmt;
        ResultSet rs;

        Class.forName("org.h2.Driver");
        try (
                Connection connection = DriverManager.getConnection(url,"sa","");
                PreparedStatement statement = connection.prepareStatement("CREATE TABLE CAR1(ID int); INSERT INTO CAR1 VALUES('1','2')");
        ) {
            statement.setInt(1, 1);
            rs = statement.executeQuery();

            if (rs.next()) {
                String byName = "ID:" + rs.getString("ID");
                System.out.println(byName);
            }
        } finally {

        }
    }*/
}}
