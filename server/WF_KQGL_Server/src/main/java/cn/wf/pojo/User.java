package cn.wf.pojo;

import java.io.Serializable;


//Serializable是序列化的接口

public class User implements Serializable {

    private int id;
    private String username;
    private String password;
    private int level;

    private String name;
    private String suozaixueyuan;
    private String suozaibanji;
    private String suoshuzhuanye;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuozaixueyuan() {
        return suozaixueyuan;
    }

    public void setSuozaixueyuan(String suozaixueyuan) {
        this.suozaixueyuan = suozaixueyuan;
    }

    public String getSuozaibanji() {
        return suozaibanji;
    }

    public void setSuozaibanji(String suozaibanji) {
        this.suozaibanji = suozaibanji;
    }

    public String getSuoshuzhuanye() {
        return suoshuzhuanye;
    }

    public void setSuoshuzhuanye(String suoshuzhuanye) {
        this.suoshuzhuanye = suoshuzhuanye;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", suozaixueyuan='" + suozaixueyuan + '\'' +
                ", suozaibanji='" + suozaibanji + '\'' +
                ", suoshuzhuanye='" + suoshuzhuanye + '\'' +
                '}';
    }
}
