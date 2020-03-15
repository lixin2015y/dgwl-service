package com.dgwl.service;

import com.dgwl.dao.UserDao;
import com.dgwl.eo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class DgwlServiceImpl implements DgwlService {


    @Autowired
    UserDao userDao;




    public User getUser(String userName, String password) {
        return userDao.selectUser(userName, password);
    }


}