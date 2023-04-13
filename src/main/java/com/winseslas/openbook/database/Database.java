/**
 * 
 */
package com.winseslas.openbook.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A utility class that provides a static method to obtain a database connection
 * This class is thread-safe.
 * @author Winseslas
 */
public class Database {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/openbook";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";

    /**
     * Returns a connection to the database
     *
     * @return a connection to the database
     * @throws SQLException if a database access error occurs
     */
    public Connection getConnection() throws SQLException {
        Connection connexion = null;
        try {
            Class.forName(JDBC_DRIVER);
            connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException cnfe) {
            throw new SQLException("Unable to load JDBC driver class", cnfe);
        }
        return connexion;
    }

    /**
     * Closes a database connection
     *
     * @param connexion the database connection to be closed
     */
    public void closeConnection(Connection connexion) {
        try {
            if (connexion != null) {
                connexion.close();
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
}
