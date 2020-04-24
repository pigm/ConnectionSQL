package com.connection.integration;

import com.connection.cross.IConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * SQLDatabaseConnection class
 */
public class SQLDatabaseConnection implements ISQLDatabaseConnection{

    private static SQLDatabaseConnection instance;

    /**
     * Instance class
     */
    public static SQLDatabaseConnection getInstance() {
        if (instance == null) {
            instance = new SQLDatabaseConnection();
        }
        return instance;
    }

    /**
     * SQL select
     */
    public void select(String table){
        String connectionUrl = IConstant.STRING_CONECCTION
            + IConstant.DATA_BASE
            + IConstant.USER
            + IConstant.PASSWORD
            + IConstant.ENCRYPT
            + IConstant.SERVER_CERTIFICATE
            + IConstant.TIMEOUT;

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {
            String selectSql = "SELECT TOP 10 * from " + table ;
            resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * SQL insert
     */
     public void insert(String table, String param1, String param2, String param3, int param4, int param5, String param6){
        String connectionUrl = IConstant.STRING_CONECCTION
            + IConstant.DATA_BASE
            + IConstant.USER
            + IConstant.PASSWORD
            + IConstant.ENCRYPT
            + IConstant.SERVER_CERTIFICATE
            + IConstant.TIMEOUT;

        String insertSql = "INSERT INTO " + table + " (Name, ProductNumber, Color, StandardCost, ListPrice, SellStartDate) VALUES "
                + "(param1, param2, param3, param4, param5, param6);";
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {
            prepsInsertProduct.execute();
            resultSet = prepsInsertProduct.getGeneratedKeys();

            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}