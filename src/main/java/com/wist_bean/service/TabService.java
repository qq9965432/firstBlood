package com.wist_bean.service;

import java.util.List;

import com.wist_bean.domain.Tab;

public interface TabService {
    List<Tab> getAllTabs();

    Tab getByTabNameEn(String tabName);
}
