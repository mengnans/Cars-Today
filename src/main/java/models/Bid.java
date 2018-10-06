package models;

import java.sql.Date;

/**
 * @author Mengnan Shi
 * @create 2018-09-28-15:24
 */

public class Bid
{
    private Long bid;
    private Long carId;
    private Long userId;
    private String address;
    private String phone;
    private String status;
    private Date date;
    private double bidPrice;
    private CarItem car;

    public Bid(Long bid, Long carId, Long userId, String address, String phone, String status, Date date, double bidPrice) {
        this.bid = bid;
        this.carId = carId;
        this.userId = userId;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.date = date;
        this.bidPrice = bidPrice;
    }


    public Bid(Long carId, Long userId, String address, String phone, double bidPrice) {
        this.carId = carId;
        this.userId = userId;
        this.address = address;
        this.phone = phone;
        this.status = "Waiting";
        this.date = new Date(System.currentTimeMillis());
        this.bidPrice = bidPrice;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public void setCar(CarItem car) {
        this.car = car;
    }

    public String getCarName() {
        return this.car.getCarName();
    }

    public String getCarImage() {
        return this.car.getImage();
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bid=" + bid +
                ", carId=" + carId +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", bidPrice=" + bidPrice +
                '}';
    }
}
