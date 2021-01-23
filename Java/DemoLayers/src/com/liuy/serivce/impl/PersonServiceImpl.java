package com.liuy.serivce.impl;

import com.liuy.dao.IPersonDao;
import com.liuy.dao.impl.PersonDaoImpl;
import com.liuy.serivce.IPersonService;

public class PersonServiceImpl implements IPersonService {

    IPersonDao personDao = new PersonDaoImpl();

}
