package domain;

import java.sql.Date;

/**
 * @author Colin
 * @create 2018-8-22 13:36:17
 */

public class ThreadItem {
    private long tid;
    private long uid;
    private Date dateTime;
    private String userName;
    private String header;
    private String content;

    public ThreadItem() { }

    public ThreadItem(User userItem, String header, String content) {
        this.dateTime = new Date(System.currentTimeMillis());
        this.uid = userItem.getUid();
        this.userName = userItem.getUserName();
        this.header = header;
        this.content = content;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ThreadItem{" +
                "tid=" + tid +
                ", uid=" + uid +
                ", dateTime=" + dateTime +
                ", userName='" + userName + '\'' +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
