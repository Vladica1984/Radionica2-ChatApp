package com.vpopovic.chataplication2017.view;

import android.content.Context;

import com.vpopovic.chataplication2017.R;

import org.androidannotations.annotations.EViewGroup;

/**
 * Created by Alen on 20-May-17.
 */

@EViewGroup(R.layout.item_view_message_incoming)
public class IncomingMessageItemView extends BaseMessageItemView {

    public IncomingMessageItemView(Context context) {
        super(context);
    }
}
