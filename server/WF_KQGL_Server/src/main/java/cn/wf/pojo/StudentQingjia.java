package cn.wf.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class StudentQingjia implements Serializable {

    private String username;
    private String name;
    private String suozaibanji;
    private String suozaixueyuan;
    private String qingjialeixing;

    private String starttime;
    private String overtime;

    private String qingjialiyou;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuozaibanji() {
        return suozaibanji;
    }

    public void setSuozaibanji(String suozaibanji) {
        this.suozaibanji = suozaibanji;
    }

    public String getSuozaixueyuan() {
        return suozaixueyuan;
    }

    public void setSuozaixueyuan(String suozaixueyuan) {
        this.suozaixueyuan = suozaixueyuan;
    }

    public String getQingjialeixing() {
        return qingjialeixing;
    }

    public void setQingjialeixing(String qingjialeixing) {
        this.qingjialeixing = qingjialeixing;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getQingjialiyou() {
        return qingjialiyou;
    }

    public void setQingjialiyou(String qingjialiyou) {
        this.qingjialiyou = qingjialiyou;
    }

    @Override
    public String toString() {
        return "Qingjia{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", suozaibanji='" + suozaibanji + '\'' +
                ", suozaixueyuan='" + suozaixueyuan + '\'' +
                ", qingjialeixing='" + qingjialeixing + '\'' +
                ", starttime='" + starttime + '\'' +
                ", overtime='" + overtime + '\'' +
                ", qingjialiyou='" + qingjialiyou + '\'' +
                '}';
    }
}
