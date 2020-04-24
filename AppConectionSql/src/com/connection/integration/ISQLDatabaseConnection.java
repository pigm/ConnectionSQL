package com.connection.integration;

/**
 * ISQLDatabaseConnection interface
 */
public interface ISQLDatabaseConnection {
    public void select(String table);
    public void insert(String table, String param1, String param2, String param3, int param4, int param5, String param6);
}
