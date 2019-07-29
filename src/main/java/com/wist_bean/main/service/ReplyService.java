package com.wist_bean.main.service;

import java.util.List;

import com.wist_bean.main.domain.Reply;

public interface ReplyService {

    List<Reply> getRepliesOfTopic(Integer topicId);

    boolean addReply(Reply reply);

    int repliesNum(Integer topicId);
}
