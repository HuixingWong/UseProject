package com.example.litemoudle.modols;

import org.litepal.crud.DataSupport;

/**
 * Created by dogoodsoft-app on 2017/11/3.
 */

public class Scene extends DataSupport {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
