package dataAccess;

import models.CarItem;
import models.CarItemDTO;
import models.StockDTO;

import java.util.ArrayList;

public class StockAssembler {

    public StockDTO writeDTO(ArrayList<CarItem> argCars) {
        StockDTO _stockDTO = new StockDTO();
        ArrayList<CarItemDTO> _lstCarDTO = new ArrayList<CarItemDTO>();
        for (int i = 1; i < argCars.size(); i++) {
            CarItemDTO _carDTO = writeCar(argCars.get(i));
            _lstCarDTO.add(_carDTO);
        }
        _stockDTO.setListCar(_lstCarDTO);
        return _stockDTO;
    }

    private CarItemDTO writeCar(CarItem carItem) {
        CarItemDTO _carDTO = new CarItemDTO();
        _carDTO.setBrand(carItem.getBrand());
        _carDTO.setCarType(carItem.getCarType());
        _carDTO.setCarName(carItem.getCarName());
        _carDTO.setTransmission(carItem.getTransmission());
        _carDTO.setEngineType(carItem.getEngineType());
        _carDTO.setImage(carItem.getImage());
        _carDTO.setPrice(carItem.getPrice());
        _carDTO.setSellerId(carItem.getSellerId());
        _carDTO.setLocation(carItem.getLocation());
        _carDTO.setMilage(carItem.getMilage());
        _carDTO.setDescription(carItem.getDescription());
        _carDTO.setStock(carItem.getStock());
        return _carDTO;
    }

}
