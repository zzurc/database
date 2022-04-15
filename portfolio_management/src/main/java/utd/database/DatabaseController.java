package utd.database;
import java.sql.*;

public class DatabaseController {
    
protected Connection connection;

    public DatabaseController() throws SQLException{
        String url = "jdbc:postgresql://ads-postgres.cm0vx7gau7uz.us-east-1.rds.amazonaws.com:5432/database_project";
        String user = "phsavov";
        String password = "PhiLeTo2001BL";
        connection = DriverManager.getConnection(url, user, password);
    }
}
