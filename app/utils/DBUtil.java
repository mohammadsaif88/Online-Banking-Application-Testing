package com.example.onlinebanking.utils;

import java.sql.*;

public class DBUtil {
    private Connection conn;

    public DBUtil() throws SQLException {
        // In-memory H2 DB
        conn = DriverManager.getConnection("jdbc:h2:mem:bankdb;DB_CLOSE_DELAY=-1", "sa", "");
    }

    public void runScript(String sql) throws SQLException {
        Statement st = conn.createStatement();
        for(String s : sql.split(";")){
            if(s.trim().isEmpty()) continue;
            st.execute(s);
        }
    }

    public ResultSet query(String q) throws SQLException {
        Statement st = conn.createStatement();
        return st.executeQuery(q);
    }

    public void execute(String q) throws SQLException {
        Statement st = conn.createStatement();
        st.execute(q);
    }

    public void close() throws SQLException { conn.close(); }
}
