import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCLesson {
    static String conStr = "jdbc:postgresql://localhost:5432/ifmo_lessons";
    static String login = "ifmo";
    static String pwd = "ifmo";

    public static void main(String[] args) {
        try {
            createTable();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() throws ClassNotFoundException, SQLException {
        String create = "CREATE TABLE IF NOT EXISTS book(" +
                "id SERIAL PRIMARY KEY," +
                "title VARCHAR(50) NOT NULL," +
                "pageCount INTEGER NOT NULL);";
        // регистрация драйвера
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(conStr, login, pwd)){
            try (Statement statement = connection.createStatement()){
                int result = statement.executeUpdate(create);
                System.out.println(result);
            }
        }
    }
}
