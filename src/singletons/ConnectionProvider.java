package singletons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
        private static final String userName = "postgres";
        private static final String password = "Coxefgu123";
        private static final String url = "jdbc:postgresql://localhost:5432/myarticleru";
        private static final String driverClassName = "org.postgresql.Driver";

        //private Connection connection;

        private ConnectionProvider() throws ClassNotFoundException {
            Class.forName(driverClassName);
        }

        public static Connection getConnection(){
            try {
                Class.forName(driverClassName);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
            try {
                return DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }
}
