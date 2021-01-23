package com.hzh.map;

public class ArrayList implements List {

    private transient Object[] date;

    private int size;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int n) {
        date = new Object[n];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i > size || i < 0) {
            throw new ArrayIndexOutOfBoundsException("数组越界:" + i);
        }
        return date[i];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        if(indexOf(e)>=0){
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object e) {
        int index = -1;

        if(e==null){
            for (int i = 0; i < date.length; i++) {
                if (date[i] == e) {
                    index = i;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < date.length; i++) {
                if (e.equals(date[i])) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    @Override
    public void add(int i, Object e) {
        if (i > size || i < 0) {
            throw new ArrayIndexOutOfBoundsException("数组越界:" + i);
        }
        if (date.length == size) {
            grow();
        }

        for (int j = size ; j >= i; j--) {
            date[j] = date[j-1];
        }
        date[i] = e;
        size++;
    }

    @Override
    public void add(Object e) {
        //上限,扩容
        if (date.length == size) {
            grow();
        }
        date[size] = e;
        size++;

    }

    //扩容函数
    private void grow() {

        int oldlength = date.length;

        int newoldlength = oldlength + (oldlength >> 1);

        Object[] arrnew = new Object[newoldlength];

        for (int i = 0; i < date.length; i++) {
            arrnew[i] = date[i];
        }

        date = arrnew;

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

    @Override
    public Iterator iterator() {
        return new IteratorImp();
    }

    public class IteratorImp<T> implements Iterator<T>{
        int cur = 0;
        @Override
        public boolean hasNext() {
            return cur!=size;
        }

        @Override
        public T next() {
            if(cur>=size){
                throw new ArrayIndexOutOfBoundsException("已经遍历完元素了");
            }
            return (T) date[cur++];
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(date[i] + ",");
        }
        if (size>0){
            builder.deleteCharAt(builder.length()-1);
        }
        builder.append("]");

        return builder.toString();
    }
}