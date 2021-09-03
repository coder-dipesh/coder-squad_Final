package code;

import java.sql.*;

public class AuthenticationDatabaseConnection {
                public static Connection databaseLink;

                public static Connection getConnection() {
                    String url = "jdbc:mysql://127.0.0.1:3306/codersquad";
                    String user = "root";
                    String password = "root";
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        databaseLink = DriverManager.getConnection(url, user, password);

                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();
                    }
                    return databaseLink;
                        }
}



