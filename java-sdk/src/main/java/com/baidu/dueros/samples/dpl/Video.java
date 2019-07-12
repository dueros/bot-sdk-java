package com.baidu.dueros.samples.dpl;

public class Video {

    private String src;
    private String index;
    private String name;
    private String desc;

    public Video(String src, String index, String name, String desc) {
        this.src = src;
        this.index = index;
        this.name = name;
        this.desc = desc;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
