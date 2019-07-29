package com.wist_bean.login.service.impl;

import com.wist_bean.login.dao.LoginLogDao;
import com.wist_bean.login.domain.LoginLog;
import com.wist_bean.login.service.LoginLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    public LoginLogDao loginLogDao;

    public boolean addLog(LoginLog log) {

        if(loginLogDao.insert(log)>0){
            return true;
        }else {
            return false;
        }
    }
}
