package com.vpopovic.chataplication2017.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vpopovic.chataplication2017.R;
import com.vpopovic.chataplication2017.fragment.CreateMessageFragment;
import com.vpopovic.chataplication2017.model.Conversation;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FragmentByTag;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_conversation)
public class ConversationActivity extends AppCompatActivity {

    @Extra
    Conversation conversation;

    @FragmentByTag
    CreateMessageFragment createMessageFragment;

    @ViewById
    RecyclerView recyclerView;

    @AfterViews
    void init() {
        createMessageFragment.initFor(conversation);

        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(
                        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
    }
}
