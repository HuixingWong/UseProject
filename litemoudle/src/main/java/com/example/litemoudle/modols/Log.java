package com.example.litemoudle.modols;

import org.litepal.crud.DataSupport;

/**
 * Created by dogoodsoft-app on 2017/11/3.
 */

public class Log extends DataSupport {

    private int id;
    private int project_id;
    private String scene_name;
    private int scene_id;

    private long startime;
    private long lengthtime;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getScene_name() {
        return scene_name;
    }

    public void setScene_name(String scene_name) {
        this.scene_name = scene_name;
    }

    public int getScene_id() {
        return scene_id;
    }

    public void setScene_id(int scene_id) {
        this.scene_id = scene_id;
    }

    public long getStartime() {
        return startime;
    }

    public void setStartime(long startime) {
        this.startime = startime;
    }

    public long getLengthtime() {
        return lengthtime;
    }

    public void setLengthtime(long lengthtime) {
        this.lengthtime = lengthtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
