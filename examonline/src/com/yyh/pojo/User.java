package com.yyh.pojo;

/**
 * @Description: com.yyh.pojo
 * @version: 1.0
 */
public class User {
    private int uid;
    private String username;
    private String password;
    private int paperId;
    private int status;

    public User() {
    }

    public User(int uid, String username, String password, int paperId, int status) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.paperId = paperId;
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", paperId=" + paperId +
                ", status=" + status +
                '}';
    }
}
