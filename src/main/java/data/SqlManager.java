package data;

import utils.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlManager {
    private boolean isTestManager = false;
    SqlManager(boolean isTestManager){
        this.isTestManager = isTestManager;
    }

    public SqlManager(){

    }

    private Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:C:/Users/ss161/Downloads/soenProjectFinal/mocktails.db";
            if(isTestManager){
                url = "jdbc:sqlite:C:/Users/ss161/Downloads/soenProjectFinal/drinksTest.db";
            }
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("SQLite Connection has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public void createTableIfNotExists(){
        String mySql = "CREATE TABLE IF NOT EXISTS drinks(\n"
                + " id text PRIMARY KEY,\n"
                + " drinkName text NOT NULL,\n"
                + " category text NOT NULL,\n"
                + " alcoholic text\n"
                + ");";

        try (Connection connection = this.connect()){
            Statement createStatement = connection.createStatement();
            createStatement.execute(mySql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void insertRecord(Drinks data){
        String mySql = "INSERT INTO " +
                "drinks(id, drinkName, category, alcoholic)" +
                "VALUES(?, ?, ?, ?)";

        try(Connection connection = this.connect()){
            PreparedStatement prepStatement = connection.prepareStatement(mySql);
            prepStatement.setString(1, data.getId());
            prepStatement.setString(2, data.getDrinkName());
            prepStatement.setString(3, data.getCategory());
            prepStatement.setString(4, data.getAlcoholic());
            prepStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Drinks> selectAllDrinks() {
        List<Drinks> drinks = new ArrayList<>();

        String mySql = "SELECT * FROM drinks";

        try(Connection connection = this.connect()){
            PreparedStatement preparedStatement = connection.prepareStatement(mySql);
            getDrinksResultSet(drinks, preparedStatement);
            return drinks;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return drinks;
    }

    //We are using LIKE here because we want to match parts of the name
    public List<Drinks> searchDrinksByName(String drinkName){
        List<Drinks> drinks = new ArrayList<>();

        String mySql = "SELECT * FROM drinks WHERE drinkName LIKE '%' || ? || '%'";

        try(Connection connection = this.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(mySql);
            System.out.println(preparedStatement);
            preparedStatement.setString(1, drinkName);
            System.out.println(preparedStatement);
            getDrinksResultSet(drinks, preparedStatement);
            System.out.println(drinks);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return drinks;
    }

    private void getDrinksResultSet(List<Drinks> drinks, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            String id = resultSet.getString("id");
            String drinkName = resultSet.getString("DrinkName");
            String category = resultSet.getString("Category");
            String alcoholic = resultSet.getString("Alcoholic");
            drinks.add(
                    new Drinks(
                            id,
                            drinkName,
                            category,
                            alcoholic
                    )
            );
        }
    }
}
