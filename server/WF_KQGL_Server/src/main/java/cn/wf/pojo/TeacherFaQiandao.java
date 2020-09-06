package cn.wf.pojo;

import java.io.Serializable;



public class TeacherFaQiandao implements Serializable {


    private int level;
    private String qiandaoma;
    private String kechengmingcheng;
    private String suozaibanji;
    private String starttime;
    private String overtime;
    private String name;
    private String faqishijian;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getQiandaoma() {
        return qiandaoma;
    }

    public void setQiandaoma(String qiandaoma) {
        this.qiandaoma = qiandaoma;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaqishijian() {
        return faqishijian;
    }

    public void setFaqishijian(String faqishijian) {
        this.faqishijian = faqishijian;
    }

    @Override
    public String toString() {
        return "TeacherFaQiandao{" +
                "level=" + level +
                ", qiandaoma='" + qiandaoma + '\'' +
                ", kechengmingcheng='" + kechengmingcheng + '\'' +
                ", suozaibanji='" + suozaibanji + '\'' +
                ", starttime='" + starttime + '\'' +
                ", overtime='" + overtime + '\'' +
                ", name='" + name + '\'' +
                ", faqishijian='" + faqishijian + '\'' +
                '}';
    }
}
