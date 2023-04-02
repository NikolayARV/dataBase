import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "Zxc13579";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE employee_id = (?)")) {
            statement.setInt(1, 3);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = "Имя: " + resultSet.getString("first_name");
                String lastName = "Фамилия: " + resultSet.getString("last_name");
                String gender = "Пол: " + resultSet.getString("gender");
                int city_id = resultSet.getInt("city_id");

                System.out.println(name);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println("id города: " + city_id);
            }

        }
    }
}

