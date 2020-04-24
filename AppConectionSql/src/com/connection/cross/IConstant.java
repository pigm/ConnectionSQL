package com.connection.cross;

/**
 * Constante interface
 */
public interface IConstant {
   public String STRING_CONECCTION =  "jdbc:sqlserver://yourserver.database.windows.net:1433;";
   public String DATA_BASE = "database=AdventureWorks;";
   public String USER = "user=yourusername@yourserver;";
   public String PASSWORD = "password=yourpassword;";
   public String ENCRYPT = "encrypt=true;";
   public String SERVER_CERTIFICATE = "trustServerCertificate=false;";
   public String TIMEOUT = "loginTimeout=30;";
}
