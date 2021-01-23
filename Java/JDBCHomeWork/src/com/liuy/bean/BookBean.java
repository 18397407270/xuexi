package com.liuy.bean;

public class BookBean {

    private int bid;
    private String bname;
    private float bprice;

    public BookBean() {
    }

    public BookBean(String bname, float bprice) {
        this.bname = bname;
        this.bprice = bprice;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public float getBprice() {
        return bprice;
    }

    public void setBprice(float bprice) {
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
