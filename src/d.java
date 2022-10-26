
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class d{
	
	public static Connection getDbConnection() throws SQLException {
        // jdbc:mysql://localhost:3306/iitstudent
        String connectionString = "jdbc:mysql://" + config.dbHost + ":" + config.dbPort
                + "/" + config.dbName;
      //  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        return DriverManager.getConnection(connectionString, config.dbUser, config.dbPass);
    }

}
