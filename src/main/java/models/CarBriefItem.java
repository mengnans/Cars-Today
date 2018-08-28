package models;

/**
 * @author Ye Yan
 * @create 2018-8-27 12:30:34
 */

public class CarBriefItem {

    private long carId;
    private int price;
    private String brand;
    private String controlType;
    private String engineType;
    private String location;
    private float usedYear;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getUsedYear() {
        return usedYear;
    }

    public void setUsedYear(float usedYear) {
        this.usedYear = usedYear;
    }

    @Override
    public String toString() {
        return "CarDetailedItem{" +
                "carId=" + carId +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", controlType='" + controlType + '\'' +
                ", engineType='" + engineType + '\'' +
                ", location='" + location + '\'' +
                ", usedYear=" + usedYear +
                '}';
    }

}
