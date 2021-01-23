package com.hzh.Stack;
/*
* 定义一个链表
* */
public class Node {
    public int date;
    public Node next;


    public Node() {
    }

    public Node(int date) {
        this.date = date;
    }

    public Node(int date, Node next) {
        this.date = date;
        this.next = next;
    }

}
