package com.wist_bean.dao;

import java.util.List;

import com.wist_bean.domain.Topic;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectById(Integer id);

    List<Topic> listTopicsAndUsers();

    List<Topic> listTopicsAndUsersOfTab(Integer tabId);

    List<Topic>  listMostCommentsTopics();

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);

    List<Topic> getAllTopics();

    int clickAddOne(Integer id);

    //获取主题总数
    int getTopicsNum();
}