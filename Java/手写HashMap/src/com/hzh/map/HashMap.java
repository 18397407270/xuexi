package com.hzh.map;

public class HashMap implements Map {

    transient Entry[] table;

    //哈希表中节点的数量
    transient int size = 0;

    //无参构造方法

    public  HashMap(){
        this(16);
    }
    public HashMap(int capacity){
        table = new Entry[capacity];
    }

    /*
    * 链表中的节点类
    * */
    class Entry implements Map.Entry{

        final Object key;

        Object value;

        Entry next;

        int hash;

        public Entry(int hash,Object key, Object value, Entry next ) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public String toString() {
            if(next!=null){
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        ", next=" + next +
                        ", hash=" + hash +
                        '}';
            }else {
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        ", hash=" + hash +
                        '}';
            }
            }

    }
    @Override
    public Object put(Object key, Object value) {
        //计算哈希值
        int hashCode = key.hashCode();
        //根据哈希值确定在主数组之中的位置
        int index = hashCode % table.length;

        //存到指定位置

        //情况一:位置为空,直接存
        if(table[index]==null) {

            //直接将节点存到数组当中
            table[index] = new Entry(hashCode,key,value,null);
            size++;
        }else {
            //情况二:指定位置不为空,发生了冲突,需要逐个比较

            //获取当前数组第一个元素
            Entry entry = table[index];

            //比较
            while (entry!=null){
                //找到相同的key
                if(entry.hash == hashCode &&(entry.key==key || entry.key.equals(key))){
                     Object v=entry.value;
                    //新的value覆盖旧的value
                     entry.value = value;
                     //返回旧的value
                     return v;
                }
                //指向下一个节点
                entry = entry.next;
            }

            //情况三:如果发生了冲突,并且key的值不相同,将这个节点加到链表的最前面
            Entry frist=table[index];
            table[index] = new Entry(hashCode,key,value,frist);
            size++;
        }
        return table[index].value;
    }

    @Override
    public Object get(Object key) {
        //计算哈希值
        int hashCode = key.hashCode();
        //根据哈希值确定在主数组之中的位置
        int index = hashCode % table.length;
        Entry entry = null;
        
        if(table[index]!=null){
            Entry  Currentry  = table[index];
            while (Currentry !=null){
                //找到相同的key
                if(Currentry .hash == hashCode &&(Currentry .key==key || Currentry .key.equals(key))){
                    entry = Currentry;
                }
                //指向下一个节点
                Currentry  = Currentry .next;
            }
        }
        
        return entry==null?null:entry.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");

        for (int i = 0; i < table.length; i++) {
            if(table[i]!=null){
                Entry entry = table[i];
                do{
                    builder.append(entry.key+"="+entry.value+",");
                     entry = entry.next;
                }while (entry!=null);
            }
        }
        if(size>0){
            builder.deleteCharAt(builder.length()-1);
        }
        builder.append("}");
        return builder.toString();
    }
}
