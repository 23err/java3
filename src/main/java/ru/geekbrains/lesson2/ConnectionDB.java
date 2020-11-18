package ru.geekbrains.lesson2;

import java.sql.*;

public class ConnectionDB {
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "1234";
    private final static String CONNECTION_STRING = "jdbc:mysql://localhost:3306/shop";


    private Connection conn;
    private Statement stmt;


    public ConnectionDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        stmt = conn.createStatement();

    }

    public boolean createTable(String name) throws SQLException {
        String query = String.format("create table if not exists %s (id serial, name varchar(255));", name);
        return stmt.execute(query);
    }

    public boolean dropTable(String name) throws SQLException {
        String query = String.format("drop table if exists %s;", name);
        return stmt.execute(query);
    }

    public boolean add(String tableName, String name) throws SQLException {
        String query = String.format("insert into %s values(null,?);", tableName);
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        System.out.println("ps.toString() = " + ps.toString());
        return ps.execute();
    }

    public int remove(String tableName, int id) throws SQLException {
        String query = String.format("delete from %s where id = ?;", tableName);
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    public ResultSet select(String tableName, int id) throws SQLException {
        String query = String.format("select * from %s where id = ?", tableName);
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);
        return ps.executeQuery();
    }

    public ResultSet select(String tableName) throws SQLException {
        String query = String.format("select * from %s", tableName);
        return stmt.executeQuery(query);
    }

    public void disconnect() throws SQLException {
        stmt.close();
        conn.close();
    }


}
