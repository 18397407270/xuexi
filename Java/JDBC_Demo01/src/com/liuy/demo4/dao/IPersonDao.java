package com.liuy.demo4.dao;

import com.liuy.demo4.info.PersonInfo;

import java.util.List;

public interface IPersonDao {

    public boolean insert(PersonInfo pi);

    public boolean update(PersonInfo pi);

    public boolean delete(int pid);

    public List<PersonInfo> query();
}
