package com.vpopovic.chataplication2017.model;

import java.io.Serializable;

/**
 * Created by Alen on 07-May-17.
 */

public abstract class BaseModel implements Serializable{

    private String id;

    public BaseModel(){

    }

    public BaseModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
