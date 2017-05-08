package com.vpopovic.chataplication2017.dao;

import com.vpopovic.chataplication2017.model.Conversation;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alen on 07-May-17.
 */
@EBean
public class ConversationDao {

    private List<Conversation> conversations = new ArrayList<>();

    @AfterInject
    void Init() {
        for (int i = 0; i <10; i++) {
            conversations.add(new Conversation(null, "Fun chat" + i));
        }
    }

    public List<Conversation> getConversations() {
        return conversations;
    }
}
