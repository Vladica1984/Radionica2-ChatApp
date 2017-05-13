package com.vpopovic.chataplication2017.generic;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Alen on 13-May-17.
 */

public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }
}
