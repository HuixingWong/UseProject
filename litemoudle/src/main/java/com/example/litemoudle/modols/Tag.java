package com.example.litemoudle.modols;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dogoodsoft-app on 2017/11/3.
 */

public class Tag extends DataSupport {

    private int id;
    private String name;
    private List<Project> projects = new ArrayList<Project>();

    public int getId() {
        return id;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
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
