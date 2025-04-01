import java.sql.*;

public class UserCRUD {
    public static void insert(Connection conn, String table, String[] columns, String[] values) throws SQLException {
        String query = String.format("INSERT INTO %s (%s) VALUES (%s)",
            table,
            String.join(", ", columns),
            String.join(", ", values));
        executeUpdate(conn, query);
    }

    public static ResultSet read(Connection conn, String table) throws SQLException {
        return conn.createStatement().executeQuery("SELECT * FROM " + table);
    }

    public static void update(Connection conn, String table, String set, String where) throws SQLException {
        executeUpdate(conn, "UPDATE " + table + " SET " + set + " WHERE " + where);
    }

    public static void delete(Connection conn, String table, String where) throws SQLException {
        executeUpdate(conn, "DELETE FROM " + table + " WHERE " + where);
    }

    private static void executeUpdate(Connection conn, String query) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        }
    }
}
