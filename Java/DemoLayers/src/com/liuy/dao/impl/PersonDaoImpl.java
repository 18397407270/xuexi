package com.liuy.dao.impl;

import com.liuy.dao.IPersonDao;
import com.liuy.info.PersonInfo;
import com.liuy.util.DBUtil;

public class PersonDaoImpl implements IPersonDao {

    /**
     * 删除person的对象
     * @param pid
     * @return
     */
    @Override
    public boolean deletePerson(int pid) {
        String sql = "delete from person where pid=?";

        return DBUtil.executeDML(sql,pid); //做了到我们的删除
    }

    /**
     * 更新我们的person的用户名
     * @param personInfo
     * @return
     */
    @Override
    public boolean updatePerson(PersonInfo personInfo){
        String sql = "update person set pname=? where pid=?";

        return DBUtil.executeDML(sql,personInfo.getPname(),personInfo.getPid());
    }

    @Override
    public boolean updatePersonNameAndAge(PersonInfo personInfo){
        String sql = "update person set pname=?,page=? where pid=?";

        return DBUtil.executeDML(sql,personInfo.getPname(),personInfo.getAge(),personInfo.getPid());
    }

    /**
     * 添加一个person信息
     * @param personInfo
     * @return
     */
    @Override
    public boolean insertPerson(PersonInfo personInfo){
        String sql = "insert into person(pname,page) values(?,?)";

        return DBUtil.executeDML(sql,personInfo.getPname(),personInfo.getAge());
    }
}
