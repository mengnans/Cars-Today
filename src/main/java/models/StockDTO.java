package models;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * @author Ye Yan
 * @create 2018-9-26 14:56:36
 */

public class StockDTO {

    private ArrayList<CarItemDTO> listCar;



    public StockDTO() { }



    public ArrayList<CarItemDTO> getListCar() {
        return listCar;
    }

    public void setListCar(ArrayList<CarItemDTO> listCar) {
        this.listCar = listCar;
    }




    public String toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }



}