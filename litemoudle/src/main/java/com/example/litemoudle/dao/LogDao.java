package com.example.litemoudle.dao;

import com.example.litemoudle.modols.Log;

import org.litepal.crud.DataSupport;

/**
 * Created by dogoodsoft-app on 2017/11/6.
 */

public class LogDao {

    public void add(Log log){

        log.save();

    }

    public void delete(Log log){

        log.delete();

    }

    public void update(Log newLog,int id){
        newLog.update(id);
    }


    public void findByid(){


    }

    public void findByProjectId(int projectId){

        DataSupport.where("project_id", String.valueOf(projectId)).find(Log.class);

    }



}
