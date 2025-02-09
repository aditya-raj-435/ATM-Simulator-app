package atm.stimulation.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLConnection {
    Connection connection;
    Statement statement;

    public SQLConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","jeya@2023sql");
            statement=connection.createStatement();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}