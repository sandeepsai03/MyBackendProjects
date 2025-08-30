package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excelr.dao.UserDao;

@Service
public class UserService {

    private UserDao dao;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public String getNameById(Integer id) {
        String name = dao.findNameById(id);
        return name;
    }

    public String getEmailById(Integer id) {
        String email = dao.findEmailById(id);
        return email;
    }
}
