package cn.wf.pojo;

import java.io.Serializable;

public class Tongzhi implements Serializable {

    private String title;
    private String zhengwen;
    private String starttime;
    private String fabuzhe;
    private String fugaibanji;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZhengwen() {
        return zhengwen;
    }

    public void setZhengwen(String zhengwen) {
        this.zhengwen = zhengwen;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getFabuzhe() {
        return fabuzhe;
    }

    public void setFabuzhe(String fabuzhe) {
        this.fabuzhe = fabuzhe;
    }

    public String getFugaibanji() {
        return fugaibanji;
    }

    public void setFugaibanji(String fugaibanji) {
        this.fugaibanji = fugaibanji;
    }

    @Override
    public String toString() {
        return "Tongzhi{" +
                "title='" + title + '\'' +
                ", zhengwen='" + zhengwen + '\'' +
                ", starttime='" + starttime + '\'' +
                ", fabuzhe='" + fabuzhe + '\'' +
                ", fugaibanji='" + fugaibanji + '\'' +
                '}';
    }
}
