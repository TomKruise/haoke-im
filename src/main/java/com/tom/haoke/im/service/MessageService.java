package com.tom.haoke.im.service;

import com.tom.haoke.im.pojo.Message;

import java.util.List;

public interface MessageService {
    List<Message> queryMessageList(Long fromId, Long toId, Integer page, Integer rows);
}
