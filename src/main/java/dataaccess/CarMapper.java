package dataaccess;

import domain.CarBriefItem;
import domain.CarDetailedItem;
import domain.ThreadItem;
import domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Ye Yan
 * @create 2018-8-27 12:31:16
 */

public class CarMapper {

    /**
     * insert a new CarDetailedItem into database
     *
     * @param carDetailedItem
     */
    public void createCar(CarDetailedItem carDetailedItem) {
        String _sql = "INSERT INTO cars (cars_id,image,price,brand,control_type,engine_type,location,seller_id,used_year,description) VALUES('"
                + carDetailedItem.getCarId() + "', '"
                + carDetailedItem.getImage() + "', '"
                + carDetailedItem.getPrice() + "', '"
                + carDetailedItem.getBrand() + "', '"
                + carDetailedItem.getControlType() + "', '"
                + carDetailedItem.getEngineType() + "', '"
                + carDetailedItem.getLocation() + "', '"
                + carDetailedItem.getSellerId() + "', '"
                + carDetailedItem.getUsedYear() + "', '"
                + carDetailedItem.getDescription() + "')";
        ExecuteNonQuerySql(_sql);
    }

    /**
     * find all cars and store the data in a CarDetailedItem object
     *
     * @return an array list that contains all CarDetailedItem objects
     */
    public ArrayList<CarDetailedItem> readCarDetailed() {
        String _sql = "SELECT * FROM cars";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        return ConvertQueryResultToCarDetailedItem(resultSet);
    }

    /**
     * find all cars and store the data in a CarBriefItem object
     *
     * @return an array list that contains all CarBriefItem objects
     */
    public ArrayList<CarBriefItem> readCarBrief() {
        String _sql = "SELECT cars_id,price,brand,control_type,engine_type,location,used_year FROM cars";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        return ConvertQueryResultToCarBriefItem(resultSet);
    }

    public void updateCar(CarDetailedItem carDetailedItem) {
        String _sql = "UPDATE from SET price= '" + carDetailedItem.getPrice() + "', description= '" + carDetailedItem.getDescription() + "' WHERE cars_id = " + "'" + carDetailedItem.getCarId() + "'";
        ExecuteNonQuerySql(_sql);
    }

    /**
     * Delete a threadItem from the database
     *
     * @param carDetailedItem
     */
    public void deleteThread(CarDetailedItem carDetailedItem) {
        String _sql = "DELETE from cars WHERE cars_id = " + "'" + carDetailedItem.getCarId() + "'";
        ExecuteNonQuerySql(_sql);
    }

    public ArrayList<CarDetailedItem> ConvertQueryResultToCarDetailedItem(ResultSet argResultSet) {
        ArrayList<CarDetailedItem> _lstThread = new ArrayList<CarDetailedItem>();
        try {
            while (argResultSet.next()) {
                CarDetailedItem _carDetailedItem = new CarDetailedItem();
                _carDetailedItem.setCarId(argResultSet.getLong("cars_id"));
                _carDetailedItem.setImage(argResultSet.getString("image"));
                _carDetailedItem.setPrice(argResultSet.getInt("price"));
                _carDetailedItem.setBrand(argResultSet.getString("brand"));
                _carDetailedItem.setControlType(argResultSet.getString("control_type"));
                _carDetailedItem.setEngineType(argResultSet.getString("engine_type"));
                _carDetailedItem.setLocation(argResultSet.getString("location"));
                _carDetailedItem.setSellerId(argResultSet.getLong("seller_id"));
                _carDetailedItem.setUsedYear(argResultSet.getLong("used_year"));
                _carDetailedItem.setDescription(argResultSet.getString("description"));
                _lstThread.add(_carDetailedItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _lstThread;
    }

    public ArrayList<CarBriefItem> ConvertQueryResultToCarBriefItem(ResultSet argResultSet) {
        ArrayList<CarBriefItem> _lstThread = new ArrayList<CarBriefItem>();
        try {
            while (argResultSet.next()) {
                CarBriefItem _carBriefItem = new CarBriefItem();
                _carBriefItem.setCarId(argResultSet.getLong("cars_id"));
                _carBriefItem.setPrice(argResultSet.getInt("price"));
                _carBriefItem.setBrand(argResultSet.getString("brand"));
                _carBriefItem.setControlType(argResultSet.getString("control_type"));
                _carBriefItem.setEngineType(argResultSet.getString("engine_type"));
                _carBriefItem.setLocation(argResultSet.getString("location"));
                _carBriefItem.setUsedYear(argResultSet.getLong("used_year"));
                _lstThread.add(_carBriefItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _lstThread;
    }

    /**
     * Do an sql execution
     *
     * @param argSql The sql command
     */
    private void ExecuteNonQuerySql(String argSql) {
        Connection _connection = null;
        try {
            _connection = DBUtils.getConnection();
            Statement statement = _connection.createStatement();
            statement.execute(argSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Do an sql query
     *
     * @param argSql The sql command
     */
    private ResultSet ExecuteQuerySql(String argSql) {
        Connection _connection = null;
        try {
            _connection = DBUtils.getConnection();
            Statement statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery(argSql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}