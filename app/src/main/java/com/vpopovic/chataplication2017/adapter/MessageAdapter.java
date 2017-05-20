package com.vpopovic.chataplication2017.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;
import com.vpopovic.chataplication2017.dao.MessageDao;
import com.vpopovic.chataplication2017.dao.UserDao;
import com.vpopovic.chataplication2017.eventbus.OttoBus;
import com.vpopovic.chataplication2017.eventbus.event.MessagesUpdatedEvent;
import com.vpopovic.chataplication2017.generic.RecyclerViewAdapterBase;
import com.vpopovic.chataplication2017.generic.ViewWrapper;
import com.vpopovic.chataplication2017.model.Conversation;
import com.vpopovic.chataplication2017.model.Message;
import com.vpopovic.chataplication2017.view.BaseMessageItemView;
import com.vpopovic.chataplication2017.view.IncomingMessageItemView_;
import com.vpopovic.chataplication2017.view.OutgoingMessageItemView;
import com.vpopovic.chataplication2017.view.OutgoingMessageItemView_;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Alen on 20-May-17.
 */

@EBean
public class MessageAdapter extends RecyclerViewAdapterBase<Message, BaseMessageItemView> {


    private static final int INCOMING_MESSAGES = 0;
    private static final int OUTGOING_MESSAGE = 1;

    @Bean
    UserDao userDao;

    @Bean
    MessageDao messageDao;

    public void initFor(Conversation conversation) {
        bus.register(this);
        messageDao.initFor(conversation);

    }
    @RootContext
    Context context;

    @Bean
    OttoBus bus;

    @Override
    protected BaseMessageItemView onCreateItemView(ViewGroup parent, int viewType) {
        switch (viewType) {
            case OUTGOING_MESSAGE:
                return OutgoingMessageItemView_.build(context);
            case INCOMING_MESSAGES:
                return IncomingMessageItemView_.build(context);
            default:
                throw new IllegalArgumentException("View type not supported");
        }
    }

    @Override
    public void onBindViewHolder(ViewWrapper<BaseMessageItemView> holder,
                                 int position) {
        final Message message = items.get(position);
        holder.getView().bind(message);
    }

    @Override
    public int getItemViewType(int position) {
        final Message message = items.get(position);

        return message.getUser().equals(userDao.getCurrentUser())
                ? OUTGOING_MESSAGE : INCOMING_MESSAGES;
    }

    @Subscribe
    public void updateMessages(MessagesUpdatedEvent event) {
        items = messageDao.getMessages();
        notifyDataSetChanged();
    }

}
