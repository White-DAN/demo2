package cn.jiaxiong.domain;

/**
 * @Author: jiaxiong
 * @Version 1.8.0_131
 *  实体类
 **/
public class Account {
    private Integer id;
    private String username;
    private Double dolary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getDolary() {
        return dolary;
    }

    public void setDolary(Double dolary) {
        this.dolary = dolary;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", dolary=" + dolary +
                '}';
    }
}
