package connector;

import com.company.Main;
import com.company.Planet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtils {
    private DBConnector dbConnector;
    private Connection connection;

    static Logger logger = LogManager.getLogger(Main.class.getName());

    public DBUtils() {
        this.dbConnector = new DBConnector();
        this.connection = this.dbConnector.getConnection();
    }

    public ResultSet getQueryResultAsResultSet(String query) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void executeInsertOrUpdateOrDeleteQuery(String query) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Planet getPlanetByName(String planetName) {
        Planet planet = new Planet();

        String planetQuery = new StringBuilder("SELECT * FROM PLANET WHERE NAME = '")
                .append(planetName)
                .append("'").toString();
        ResultSet resultSet = this.getQueryResultAsResultSet(planetQuery);

        try {
            resultSet.next();

            String name = resultSet.getString("NAME");
            int mass = resultSet.getInt("MASS");
            int radius = resultSet.getInt("RADIUS");
            int planetIndex = resultSet.getInt("PLANET_INDEX");

            planet = new Planet(name, mass, radius, planetIndex);

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return planet;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
