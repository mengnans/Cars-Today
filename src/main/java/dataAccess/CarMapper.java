package dataAccess;

import models.CarItem;

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
    public void createCar(CarItem carItem) {
        String _sql = "INSERT INTO cars (brand,car_type,car_name,transmission,engine_type,image,price,seller_id,location,milage,description,stock) VALUES('"
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
    public ArrayList<CarItem> readCar() {
        String _sql = "SELECT * FROM cars";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        return ConvertQueryResultToCarDetailedItem(resultSet);
    }

    public void updateCar(CarItem carItem) {
        String _sql = "UPDATE cars SET " +
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
    }

    /**
     * Delete a CarItem from the database
     *
     * @param carItem
     */
    public void deleteCar(CarItem carItem) {
        String _sql = "DELETE from cars WHERE cars_id = " + "'" + carItem.getCarId() + "'";
        ExecuteNonQuerySql(_sql);
    }

    public ArrayList<CarItem> ConvertQueryResultToCarDetailedItem(ResultSet argResultSet) {
        ArrayList<CarItem> _lstThread = new ArrayList<CarItem>();
        try {
            while (argResultSet.next()) {
                CarItem _carItem = new CarItem();
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