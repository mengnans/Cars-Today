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

    private static CarMapper CarMapper;

    static {
        CarMapper = new CarMapper();
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

}