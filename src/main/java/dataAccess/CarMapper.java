package dataAccess;

import models.CarItem;

import javax.xml.stream.FactoryConfigurationError;
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
     * insert a new CarItem into database
     *
     * @param carItem
     */
    public static void createCar(CarItem carItem) {
        String _sql = "INSERT INTO cars (version,brand,car_type,car_name,transmission,engine_type,image,price,seller_id,location,milage,description,stock) VALUES('"
                + carItem.getVersion() + "', '"
                + carItem.getBrand() + "', '"
                + carItem.getCarType() + "', '"
                + carItem.getCarName() + "', '"
                + carItem.getTransmission() + "', '"
                + carItem.getEngineType() + "', '"
                + carItem.getImage() + "', '"
                + carItem.getPrice() + "', '"
                + carItem.getSellerId() + "', '"
                + carItem.getLocation() + "', '"
                + carItem.getMilage() + "', '"
                + carItem.getDescription() + "', '"
                + carItem.getStock() + "')";
        ExecuteNonQuerySql(_sql);
    }

    /**
     * find all cars and store the data in a CarItem object
     *
     * @return an array list that contains all CarItem objects
     */
    public static ArrayList<CarItem> readCar() {
        String _sql = "SELECT * FROM cars where stock > 0";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        return ConvertQueryResultToCarDetailedItem(resultSet);
    }

    /**
     * find all cars and store the data in a CarItem object
     *
     * @return an array list that contains all CarItem objects
     */
    public static ArrayList<CarItem> readUserUsedCar(String argUserId) {
        String _sql = "SELECT * FROM cars where seller_id='" + argUserId + "'";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        return ConvertQueryResultToCarDetailedItem(resultSet);
    }

    /**
     * find cars and store the data in a CarItem object
     *
     * @return an array list that contains all CarItem objects
     */
    public static ArrayList<CarItem> readCarByID(String argID) {
        String _sql = "SELECT * FROM cars WHERE cars_id='" + argID + "'";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        return ConvertQueryResultToCarDetailedItem(resultSet);
    }

    public static ArrayList<String> readAllBrand() {
        String _sql = "SELECT DISTINCT brand FROM cars";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        ArrayList<String> _lstBrand = new ArrayList<String>();
        try {
            while (resultSet.next()) {
                _lstBrand.add(resultSet.getString("brand"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _lstBrand;
    }

    /**
     * find cars of given brand and store the data in a CarItem object
     *
     * @return an array list that contains all CarItem objects
     */
    public static ArrayList<CarItem> readCarByBrand(String argBrand) {
        String _sql = "SELECT * FROM cars WHERE brand='" + argBrand + "'";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        return ConvertQueryResultToCarDetailedItem(resultSet);
    }

    /**
     * synchronized method makes sure only one thread can update the
     * data
     *
     * @param carItem carItem object, which contains all the info
     *                for the car
     */
    public synchronized static boolean updateCar(CarItem carItem) {
        ArrayList<CarItem> _lstCar = readCarByID(carItem.getCarId() + "");
        if (_lstCar.get(0).getVersion() != carItem.getVersion()) return false;

        String _sql = "UPDATE cars SET " +
                "version= '" + (carItem.getVersion() + 1) + "', " +
                "brand= '" + carItem.getBrand() + "', " +
                "car_type= '" + carItem.getCarType() + "', " +
                "car_name= '" + carItem.getCarName() + "', " +
                "transmission= '" + carItem.getTransmission() + "', " +
                "engine_type= '" + carItem.getEngineType() + "', " +
                "image= '" + carItem.getImage() + "', " +
                "price= '" + carItem.getPrice() + "', " +
                "seller_id= '" + carItem.getSellerId() + "', " +
                "location= '" + carItem.getLocation() + "', " +
                "milage= '" + carItem.getMilage() + "', " +
                "description= '" + carItem.getDescription() + "', " +
                "stock= '" + carItem.getStock() + "'  " +
                "WHERE cars_id = " + "'" + carItem.getCarId() + "'";
        ExecuteNonQuerySql(_sql);
        return true;
    }

    /**
     * Delete a CarItem from the database
     *
     * @param carItem
     */
    public static void deleteCar(CarItem carItem) {
        String _sql = "DELETE from cars WHERE cars_id = " + "'" + carItem.getCarId() + "'";
        ExecuteNonQuerySql(_sql);
    }

    public static ArrayList<CarItem> ConvertQueryResultToCarDetailedItem(ResultSet argResultSet) {
        ArrayList<CarItem> _lstThread = new ArrayList<CarItem>();
        try {
            while (argResultSet.next()) {
                CarItem _carItem = new CarItem();
                _carItem.setVersion(argResultSet.getInt("version"));
                _carItem.setCarId(argResultSet.getLong("cars_id"));
                _carItem.setBrand(argResultSet.getString("brand"));
                _carItem.setCarType(argResultSet.getString("car_type"));
                _carItem.setCarName(argResultSet.getString("car_name"));
                _carItem.setTransmission(argResultSet.getString("transmission"));
                _carItem.setEngineType(argResultSet.getString("engine_type"));
                _carItem.setImage(argResultSet.getString("image"));
                _carItem.setPrice(argResultSet.getInt("price"));
                _carItem.setSellerId(argResultSet.getLong("seller_id"));
                _carItem.setLocation(argResultSet.getString("location"));
                _carItem.setMilage(argResultSet.getInt("milage"));
                _carItem.setDescription(argResultSet.getString("description"));
                _carItem.setStock(argResultSet.getInt("stock"));
                _lstThread.add(_carItem);
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
    private static void ExecuteNonQuerySql(String argSql) {
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
    private static ResultSet ExecuteQuerySql(String argSql) {
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