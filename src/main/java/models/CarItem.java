package models;

/**
 * @author Ye Yan
 * @create 2018-8-27 12:30:38
 */

public class CarItem {

    private long carId;

    private String brand;
    private String carType;
    private String carName;
    private String transmission;
    private String engineType;

    private String image;
    private int price;
    private long sellerId;
    private String location;
    private int milage;
    private String description;
    private int stock;

    public long getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarType() {
        return carType;
    }

    public String getCarName() {
        return carName;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }

    public long getSellerId() {
        return sellerId;
    }

    public String getLocation() {
        return location;
    }

    public int getMilage() {
        return milage;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }


    public void setCarId(long carId) {
        this.carId = carId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "CarItem{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", carType='" + carType + '\'' +
                ", carName='" + carName + '\'' +
                ", transmission='" + transmission + '\'' +
                ", engineType='" + engineType + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", sellerId=" + sellerId +
                ", location='" + location + '\'' +
                ", milage=" + milage +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                '}';
    }
}
