package com.vpopovic.chataplication2017.fragment;



import android.support.v4.app.Fragment;

import android.widget.EditText;

import com.vpopovic.chataplication2017.R;
import com.vpopovic.chataplication2017.dao.MessageDao;
import com.vpopovic.chataplication2017.model.Conversation;
import com.vpopovic.chataplication2017.model.Message;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_create_message)
public class CreateMessageFragment extends Fragment {


    public CreateMessageFragment() {
        // Required empty public constructor
    }


    @Bean
    MessageDao messageDao;

    @ViewById
    EditText messageText;

    public void initFor(Conversation conversation) {
        messageDao.initFor(conversation);
    }

    @Click
    void sendMessage() {
        final String text = messageText.getText().toString();
        if (text.isEmpty()) {
            return;
        }

        final Message message = new Message(text);
        messageDao.write(message);
        messageText.setText("");
    }
}
