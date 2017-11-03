package com.example.litemoudle.modols;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by dogoodsoft-app on 2017/11/3.
 */

public class Project extends DataSupport {


    private int id;
    private String name;
    private List<Integer> tags_id;

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

    public List<Integer> getTags_id() {
        return tags_id;
    }

    public void setTags_id(List<Integer> tags_id) {
        this.tags_id = tags_id;
    }
}
