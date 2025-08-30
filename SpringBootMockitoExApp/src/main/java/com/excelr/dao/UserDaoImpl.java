package com.excelr.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public String findNameById(Integer id) {
        System.out.println("findNameById() called");
        return "Bhavi";
    }

    public String findEmailById(Integer id) {
        System.out.println("findEmailById() called");
        return "Bhavi@123";
    }
}
