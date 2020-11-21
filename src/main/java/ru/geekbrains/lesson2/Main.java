package ru.geekbrains.lesson2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        ConnectionDB connectionDB = null;
        try {
            connectionDB = new ConnectionDB();
            System.out.println("drop table = " + connectionDB.dropTable("test_table"));
            System.out.println("create table = " + connectionDB.createTable("test_table"));
            System.out.println("add item = " + connectionDB.add("test_table", "ivan"));
            System.out.println("select = " + connectionDB.select("test_table"));

            ResultSet rs = connectionDB.select("test_table");
            while (rs.next()) {
                System.out.printf("id = %d name = %s%n", rs.getInt(1), rs.getString(2));
            }

            System.out.println("remove item = " + connectionDB.remove("test_table", 1));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connectionDB.disconnect();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
