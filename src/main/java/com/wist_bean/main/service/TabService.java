package com.wist_bean.main.service;

import java.util.List;

import com.wist_bean.main.domain.Tab;

public interface TabService {
    List<Tab> getAllTabs();

    Tab getByTabNameEn(String tabName);
}
