package com.example.litemoudle.modols;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dogoodsoft-app on 2017/11/3.
 */

public class Scene extends DataSupport {

    private int id;
    private String name;

    private List<Log> list = new ArrayList<Log>();

    public List<Log> getList() {
        return list;
    }

    public void setList(List<Log> list) {
        this.list = list;
    }

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
