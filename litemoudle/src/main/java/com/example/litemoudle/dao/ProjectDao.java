package com.example.litemoudle.dao;

import com.example.litemoudle.modols.Project;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by dogoodsoft-app on 2017/11/6.
 */

public class ProjectDao {



    public void add(Project project) {

        String name = project.getName();
        List<Project> projectByName = findProjectByName(name);
        if (projectByName.size() == 0){
            project.save();
        }

    }

    public void update(Project newProject,int projectId) {

        newProject.update(projectId);

    }


    public void delete(Project project) {

        project.delete();
    }



    public List<Project> findProjectByName(String name) {

        List<Project> projects = DataSupport.where("name = ?", name).find(Project.class);

        return projects;

    }

    public Project findFirstProjectByName(String name) {

        List<Project> projects = DataSupport.where("name = ?", name).find(Project.class);

        return projects.get(0);

    }
}

