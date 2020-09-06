package cn.wf.pojo;


import java.io.Serializable;

public class StudentQiandao implements Serializable {


    private String Username;
    private String name;
    private int qiandaozhuangtai;
    private String kechengmingcheng;
    private String suozaibanji;

    private String overtime;
    private String qiandaoma;
    private String faqishijian;


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQiandaozhuangtai() {
        return qiandaozhuangtai;
    }

    public void setQiandaozhuangtai(int qiandaozhuangtai) {
        this.qiandaozhuangtai = qiandaozhuangtai;
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

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getQiandaoma() {
        return qiandaoma;
    }

    public void setQiandaoma(String qiandaoma) {
        this.qiandaoma = qiandaoma;
    }

    public String getFaqishijian() {
        return faqishijian;
    }

    public void setFaqishijian(String faqishijian) {
        this.faqishijian = faqishijian;
    }

    @Override
    public String toString() {
        return "StudentQiandao{" +
                "Username='" + Username + '\'' +
                ", name='" + name + '\'' +
                ", qiandaozhuangtai=" + qiandaozhuangtai +
                ", kechengmingcheng='" + kechengmingcheng + '\'' +
                ", suozaibanji='" + suozaibanji + '\'' +
                ", overtime='" + overtime + '\'' +
                ", qiandaoma='" + qiandaoma + '\'' +
                ", faqishijian='" + faqishijian + '\'' +
                '}';
    }
}
