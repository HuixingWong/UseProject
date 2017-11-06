package com.example.litemoudle.modols;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dogoodsoft-app on 2017/11/3.
 */

public class Project extends DataSupport {


    private int id;
    private String name;
    private List<Tag> Tags = new ArrayList<>();

    private List<Log> logs = new ArrayList<>();

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public List<Tag> getTags() {
        return Tags;
    }

    public void setTags(List<Tag> tags) {
        Tags = tags;
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

    public List<Log> getLogs(int id){

        return DataSupport.where("id = ?", String.valueOf(id)).find(Log.class);

    }


}
