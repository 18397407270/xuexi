package com.hzh.map;

public class LinkedList implements List{

    transient int size = 0;//有几个节点

    transient Node first;//指向第一个节点
    transient Node last;//指向最后一个节点

    private static class Node<E> {
        E item;
       Node<E> next;
       Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        return node(i).item;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(int i, Object e) {
        checkPositionIndex(i);

        if (i == size)
            linkLast(e);
        else
            linkBefore(e, node(i));

    }
    Node node(int index) {

        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    void linkBefore(Object e, Node succ) {
        // assert succ != null;
        final Node pred = succ.prev;
        final Node newNode = new Node(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    public void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    public boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
    public String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }


    @Override
    public void add(Object e) {
        linkLast(e);
    }
    void linkLast(Object e) {
        final Node l = last;
        final Node newNode = new Node(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public boolean remove(Object e) {
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }


}
