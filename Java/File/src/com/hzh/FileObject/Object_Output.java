package com.hzh.FileObject;

import java.io.*;

public class Object_Output {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //M_ObjectOutput();
        M_ObjectInput();
    }

    private static void M_ObjectInput() throws IOException, ClassNotFoundException {
        ObjectInput o1 = new ObjectInputStream(new FileInputStream("People_Information.txt"));
        Object o = o1.readObject();
        o1.close();

        Person p1 = (Person)o;
        System.out.println("姓名:"+p1.getName()+"----年龄:"+p1.getAge());

    }

    private static void M_ObjectOutput() throws IOException {
        ObjectOutput o1 = new ObjectOutputStream(new FileOutputStream("People_Information.txt"));
        o1.writeObject( new Person("李华",18));
        o1.close();
    }
}
