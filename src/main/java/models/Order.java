package models;

import java.sql.Date;

/**
 * @author Mengnan Shi
 * @create 2018-09-01-12:10
 */

public class Order {

    private Long oId;
    private Long carId;
    private Long userId;
    private String address;
    private String phone;
    private String status;
    private Date date;

    // this attribute is actually duplicate
    // with the car id, it's only used for
    // showing the detail info of a car on
    // the order page
    private CarItem car;

    /**
     * constructor for new order, it does not
     * indicate the order id, our database will
     * automatically generate one for it
     * The initial status will be "initializing"
     *
     * @param carId   car Id
     * @param userId  user Id
     * @param address user delivery address
     * @param phone   user contact phone
     */
    public Order(Long carId, Long userId, String address, String phone) {
        this.carId = carId;
        this.userId = userId;
        this.address = address;
        this.phone = phone;
        this.status = "Initializing";
        this.date = new Date(System.currentTimeMillis());
    }

    /**
     * Constructor
     *
     * @param oId
     * @param carId
     * @param userId
     * @param address
     * @param phone
     * @param status
     * @param date
     */
    public Order(Long oId, Long carId, Long userId, String address, String phone, String status, Date date) {
        this.oId = oId;
        this.carId = carId;
        this.userId = userId;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.date = date;
    }

    public Long getOId() {
        return oId;
    }

    public void setOId(Long oId) {
        this.oId = oId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCarImage() {
        return this.car.getImage();
    }

    public String getCarName() {
        return this.car.getCarName();
    }

    public void setCar(CarItem car) {
        this.car = car;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", carId=" + carId +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
