package com.aaa.entity;

public class Clable {
    private Integer clableid;
    private  String clablename;
    private  Integer userid;

    public Integer getClableid() {
        return clableid;
    }

    public void setClableid(Integer clableid) {
        this.clableid = clableid;
    }

    public String getClablename() {
        return clablename;
    }

    public void setClablename(String clablename) {
        this.clablename = clablename;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Clable{" +
                "clableid=" + clableid +
                ", clablename='" + clablename + '\'' +
                ", userid=" + userid +
                '}';
    }

    public Clable(Integer clableid, String clablename, Integer userid) {
        this.clableid = clableid;
        this.clablename = clablename;
        this.userid = userid;
    }

    public Clable() {
    }
}
