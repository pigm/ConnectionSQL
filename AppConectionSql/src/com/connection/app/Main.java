package com.connection.app;

import com.connection.integration.SQLDatabaseConnection;

/**
 * Main class
 */
public class Main {

    /**
     * Run main
     */
    public static void main(String[] args) {
        System.out.println("---Connection SQL---");
        SQLDatabaseConnection.getInstance().insert("SalesLT.Product", "NewBike", "BikeNew", "Blue", 50, 120, "2016-01-01");
        SQLDatabaseConnection.getInstance().select("SalesLT.Customer");
        System.out.println("---End Connection SQL---");
    }
}
