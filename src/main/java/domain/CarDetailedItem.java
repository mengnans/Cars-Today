package domain;

/**
 * @author Ye Yan
 * @create 2018-8-27 12:30:38
 */

public class CarDetailedItem {

    private long carId;
    private String image;
    private int price;
    private String brand;
    private String controlType;
    private String engineType;
    private String location;
    private long sellerId;
    private float usedYear;
    private String description;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public float getUsedYear() {
        return usedYear;
    }

    public void setUsedYear(float usedYear) {
        this.usedYear = usedYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CarDetailedItem{" +
                "carId=" + carId +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", controlType='" + controlType + '\'' +
                ", engineType='" + engineType + '\'' +
                ", location='" + location + '\'' +
                ", sellerId=" + sellerId +
                ", usedYear=" + usedYear +
                ", description='" + description + '\'' +
                '}';
    }

}
