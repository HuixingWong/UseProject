package com.example.litemoudle.modols;

import org.litepal.crud.DataSupport;

/**
 * Created by dogoodsoft-app on 2017/11/3.
 */

public class Log extends DataSupport {

    private int id;

    private long startime;
    private long lengthtime;
    private String content;

    private Project project;

    private Scene scene;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
