package dataAccess;

import models.CarItem;

import java.util.ArrayList;

/**
 * @author Ye Yan
 * @create 2018-9-26 15:28:01
 */
public class CarFacade {

    public String[] getCarMessages(String argID) {
        ArrayList<CarItem> _lstCars = CarMapper.readCarByID(argID);
        if (_lstCars.size() == 0) return null;

        CarItem _car = _lstCars.get(0);
        String[] _blkData = new String[13];
        _blkData[0] = _car.getCarName();
        _blkData[1] = _car.getBrand();
        _blkData[2] = _car.getCarType();
        _blkData[3] = _car.getCarName();
        _blkData[4] = _car.getTransmission();
        _blkData[5] = _car.getEngineType();
        _blkData[6] = _car.getImage();
        _blkData[7] = _car.getPrice() + "";
        _blkData[8] = _car.getSellerId() + "";
        _blkData[9] = _car.getLocation();
        _blkData[10] = _car.getMilage() + "";
        _blkData[11] = _car.getDescription();
        _blkData[12] = _car.getStock() + "";
        return _blkData;
    }
}