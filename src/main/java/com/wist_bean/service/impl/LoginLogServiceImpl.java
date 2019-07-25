package com.wist_bean.service.impl;

import com.wist_bean.dao.LoginLogMapper;
import com.wist_bean.domain.LoginLog;
import com.wist_bean.service.LoginLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    public LoginLogMapper loginLogDao;

    public boolean addLog(LoginLog log) {

        if(loginLogDao.insert(log)>0){
            return true;
        }else {
            return false;
        }
    }
}
