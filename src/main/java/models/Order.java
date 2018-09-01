package models;

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

    /**
     * constructor for new order, it does not
     * indicate the order id, our database will
     * automatically generate one for it
     * The initial status will be "initializing"
     * @param carId car Id
     * @param userId user Id
     * @param address user delivery address
     * @param phone user contact phone
     */
    public Order(Long carId, Long userId, String address, String phone) {
        this.carId = carId;
        this.userId = userId;
        this.address = address;
        this.phone = phone;
        this.status = "Initializing";
    }

    /**
     * Constructor used for read all data from database
     * @param oId
     * @param carId
     * @param userId
     * @param address
     * @param phone
     * @param status
     */
    public Order(Long oId, Long carId, Long userId, String address, String phone, String status) {
        this.oId = oId;
        this.carId = carId;
        this.userId = userId;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
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
