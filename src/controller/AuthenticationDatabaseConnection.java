package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class AuthenticationDatabaseConnection {
                public static Connection databaseLink;

                public static Connection getConnection() {
                    String url = "jdbc:mysql://127.0.0.1:3306/codersquad";
                    String user = "root";
                    String password = "galacticos2001";
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



