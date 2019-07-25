package com.wist_bean.service;

import java.util.List;

import com.wist_bean.domain.Reply;

public interface ReplyService {

    List<Reply> getRepliesOfTopic(Integer topicId);

    boolean addReply(Reply reply);

    int repliesNum(Integer topicId);
}
