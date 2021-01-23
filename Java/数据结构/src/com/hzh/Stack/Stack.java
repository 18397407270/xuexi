package com.hzh.Stack;

public class Stack {
    public Node topStack;
    public Node bottomStack;

    public Stack() {
    }

    public Stack(Node topStack, Node bottomStack) {
        this.topStack = topStack;
        this.bottomStack = bottomStack;
    }

    public void push(int data){
        if(topStack == null){
            //栈为空,将数据存入头结点
            topStack = new Node(data);
            //栈尾与头结点在一块内存
            bottomStack = topStack;

        }else{
            //当栈不为空时
           Node node =new Node(data);
           node.next=bottomStack;
           bottomStack= node;
        }
    }
    public void pop (){
        if(bottomStack !=null){
            Node node = bottomStack;
            bottomStack=bottomStack.next;
            System.out.println(node.date);
        }else{
            System.out.println("栈空了");
        }

    }
}
