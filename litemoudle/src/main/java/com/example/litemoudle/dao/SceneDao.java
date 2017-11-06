package com.example.litemoudle.dao;

import com.example.litemoudle.modols.Scene;
import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by huixing on 2017/11/6.
 */

public class SceneDao {


    public void add(Scene scene) {

        List<Scene> scenes = DataSupport.where("name = ?", scene.getName()).find(Scene.class);
        if (scenes.size() == 0){

            scene.save();

        }


    }

    public void update(Scene scene) {



    }

    public void delete(Scene scene) {

        scene.delete();


    }

    public Scene findSeneByname(String name) {

        List<Scene> scenes = DataSupport.where("name", name).find(Scene.class);
        if (scenes.size()>0){

            return scenes.get(0);

        }else {

            return null;
        }


    }
}
