package dataAccess;

import models.CarItem;
import models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Ye Yan
 * @create 2018-8-28 13:54:52
 */
public class CarMapperTest {

    static { }

    @Test
    void createDemoCars() {
        String _value = "100";
        int _value1 = Integer.parseInt(_value);
        ArrayList<CarItem> _data = CarMapper.readCarByID("3");
        int a = 1;
//        CarMapper.createCar(new CarItem("Brand1", "Type1", "Name1", "Transmission1", "Engine1", "", 1, 0, "Location1", 1, "Description1", 1));
//        CarMapper.createCar(new CarItem("Brand2", "Type2", "Name2", "Transmission2", "Engine2", "", 2, 0, "Location2", 2, "Description2", 2));
//        CarMapper.createCar(new CarItem("Brand3", "Type3", "Name3", "Transmission3", "Engine3", "", 3, 0, "Location3", 3, "Description3", 3));
    }

    @Test
    void createTest() {
        CarItem _item = new CarItem();
        _item.setBrand("NewBrand");
        _item.setDescription("TestDescription");
        CarMapper.createCar(_item);

        CarItem _itemNew = CarMapper.readCar().get(0);
        assert _item.getBrand().equals(_itemNew.getBrand());
        assert _item.getDescription().equals(_itemNew.getDescription());
    }

    @Test
    void updateTest() {
        CarItem _item = CarMapper.readCar().get(0);
        _item.setBrand("NewHeader");
        _item.setDescription("NewContent");

        CarMapper.updateCar(_item);
        CarItem _itemNew = CarMapper.readCar().get(0);
        assert _item.getBrand().equals(_itemNew.getBrand());
        assert _item.getDescription().equals(_itemNew.getDescription());
    }

    @Test
    void deleteTest() {
        CarItem _item = CarMapper.readCar().get(0);
        CarMapper.deleteCar(_item);

        ArrayList<CarItem> _lst = CarMapper.readCar();
        assert _lst.size() == 0;
    }

    @Test
    void readCarByIdTest (){
        CarItem car = CarMapper.readCarByID(""+1).get(0);
        assert car.getCarName().equals("Tiguan");
    }
}