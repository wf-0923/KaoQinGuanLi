package cn.wf.pojo;

import java.io.Serializable;

public class Teachers  implements Serializable {

    private String username;
    private String name;
    private String kechengmingcheng;
    private String suozaibanji;

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

    public String getKechengmingcheng() {
        return kechengmingcheng;
    }

    public void setKechengmingcheng(String kechengmingcheng) {
        this.kechengmingcheng = kechengmingcheng;
    }

    public String getSuozaibanji() {
        return suozaibanji;
    }

    public void setSuozaibanji(String suozaibanji) {
        this.suozaibanji = suozaibanji;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", kechengmingcheng='" + kechengmingcheng + '\'' +
                ", suozaibanji='" + suozaibanji + '\'' +
                '}';
    }
}
