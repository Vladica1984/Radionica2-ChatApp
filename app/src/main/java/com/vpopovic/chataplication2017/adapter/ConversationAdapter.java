package com.vpopovic.chataplication2017.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.otto.Subscribe;
import com.vpopovic.chataplication2017.dao.ConversationDao;
import com.vpopovic.chataplication2017.eventbus.OttoBus;
import com.vpopovic.chataplication2017.eventbus.event.ConversationsUpdatedEvent;
import com.vpopovic.chataplication2017.model.Conversation;
import com.vpopovic.chataplication2017.view.ConversationItemView;
import com.vpopovic.chataplication2017.view.ConversationItemView_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alen on 07-May-17.
 */
@EBean
public class ConversationAdapter extends BaseAdapter {

    private List<Conversation> conversations = new ArrayList<>();
    @RootContext
    Context context;

    @Bean
    ConversationDao conversationDao;

    @Bean
    OttoBus bus;

    @AfterInject
     void init() {
        bus.register(this);
    }

    public void resetConversationFlow() {
        conversationDao.init();
    }

    @Override
    public int getCount() {
        return conversations.size();
    }

    @Override
    public Conversation getItem(int position) {
        return conversations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ConversationItemView conversationItemView;
        if (convertView == null) {
            conversationItemView = ConversationItemView_.build(context);
        } else {
            conversationItemView = (ConversationItemView) convertView;
        }

        conversationItemView.bind(getItem(position));

        return conversationItemView;
    }

    private void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;

        // notify that data set changed so that the list is refreshed
        notifyDataSetChanged();
    }

    @Subscribe
    public void conversationsUpdated(ConversationsUpdatedEvent event) {
        setConversations(conversationDao.getConversations());
        notifyDataSetChanged();
    }
}
