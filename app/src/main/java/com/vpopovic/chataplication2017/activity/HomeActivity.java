package com.vpopovic.chataplication2017.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.vpopovic.chataplication2017.R;
import com.vpopovic.chataplication2017.adapter.ConversationAdapter;
import com.vpopovic.chataplication2017.model.Conversation;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_home)
public class HomeActivity extends AppCompatActivity {

    @ViewById
    ListView listView;

    @Bean
    ConversationAdapter conversationAdapter;

    @AfterViews
    void init() {
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            LoginActivity_.intent(this).start();
        }
        listView.setAdapter(conversationAdapter);
    }

    @ItemClick
    void listViewItemClicked(Conversation conversation) {

        ConversationActivity_
                .intent(this)
                .conversation(conversation)
                .start();
    }

    @Click
    void fab() {
        CreateConversationActivity_.intent(this).start();
    }
}
