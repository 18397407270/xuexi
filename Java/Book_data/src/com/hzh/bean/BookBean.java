package com.hzh.bean;

public class BookBean {
    private Integer bid;
    private String bname;
    private double bprice;

    public BookBean() {
    }


    public BookBean(String bname) {
        this.bname = bname;
    }

    public BookBean(String bname, double bprice) {
        this.bname = bname;
        this.bprice = bprice;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getBprice() {
        return bprice;
    }

    public void setBprice(double bprice) {
        this.bprice = bprice;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bprice=" + bprice +
                '}';
    }
}
