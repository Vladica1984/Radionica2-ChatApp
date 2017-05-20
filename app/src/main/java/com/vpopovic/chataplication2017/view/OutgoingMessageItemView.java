package com.vpopovic.chataplication2017.view;

import android.content.Context;

import com.vpopovic.chataplication2017.R;

import org.androidannotations.annotations.EViewGroup;

/**
 * Created by Alen on 20-May-17.
 */

@EViewGroup(R.layout.item_view_message_outgoing)
public class OutgoingMessageItemView extends BaseMessageItemView {

    public OutgoingMessageItemView(Context context) {
        super(context);
    }
}
