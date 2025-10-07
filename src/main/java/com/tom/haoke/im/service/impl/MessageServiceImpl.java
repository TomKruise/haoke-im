package com.tom.haoke.im.service.impl;

import com.tom.haoke.im.dao.MessageDAO;
import com.tom.haoke.im.pojo.Message;
import com.tom.haoke.im.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDAO messageDAO;

    @Override
    public List<Message> queryMessageList(Long fromId, Long toId, Integer page, Integer rows) {
        List<Message> list = this.messageDAO.findListByFromAndTo(fromId, toId, page, rows);
        for (Message message : list) {
            if (message.getStatus().intValue() == 1) {
                // 修改消息状态为已读
                this.messageDAO.updateMessageState(message.getId(), 2);
            }
        }
        return list;
    }
}
