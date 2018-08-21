package domain;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-17:47
 */

public class AdminTable {
    private int aid;
    private String adminName;
    private String adminId;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
