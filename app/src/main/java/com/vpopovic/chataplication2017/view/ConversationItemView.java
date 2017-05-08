package com.vpopovic.chataplication2017.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vpopovic.chataplication2017.R;
import com.vpopovic.chataplication2017.model.Conversation;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Alen on 07-May-17.
 */

@EViewGroup(R.layout.item_view_conversation)
public class ConversationItemView extends LinearLayout {

    @ViewById
    TextView title;

    public ConversationItemView(Context context) {
        super(context);
    }

    public void bind(Conversation conversation) {
        title.setText(conversation.getTitle());
    }
}
