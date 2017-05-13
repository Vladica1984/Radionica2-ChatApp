package com.vpopovic.chataplication2017.eventbus;

import com.squareup.otto.Bus;

import org.androidannotations.annotations.EBean;

/**
 * Created by Alen on 13-May-17.
 */

@EBean(scope = EBean.Scope.Singleton)
public class OttoBus extends Bus {

}