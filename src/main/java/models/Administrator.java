package models;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-17:47
 */

public class Administrator {
    private long aid;
    private String adminName;
    private String password;

    public Administrator(long aid, String adminName, String password) {
        this.aid = aid;
        this.adminName = adminName;
        this.password = password;
    }

    public Administrator(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "aid=" + aid +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
