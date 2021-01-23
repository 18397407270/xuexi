package com.liuy.dao;

import com.liuy.info.PersonInfo;

public interface IPersonDao {

    public boolean deletePerson(int pid);

    public boolean updatePerson(PersonInfo personInfo);

    public boolean updatePersonNameAndAge(PersonInfo personInfo);

    public boolean insertPerson(PersonInfo personInfo);
}
