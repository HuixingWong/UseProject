package com.example.litemoudle.dao;

import android.widget.Toast;

import com.example.litemoudle.NyApp;
import com.example.litemoudle.modols.Project;
import com.example.litemoudle.modols.Scene;
import com.example.litemoudle.modols.Tag;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by huixing on 2017/11/6.
 */

public class TagDao {

    public void add(Tag tag){

        List<Tag> tags = DataSupport.where("name = ?", tag.getName()).find(Tag.class);
        if (tags.size() == 0){

            tag.save();

        }else {
            Toast.makeText(NyApp.getContext(), "已经存在该标签", Toast.LENGTH_SHORT).show();
        }

    }
    public void update(){

    }
    public void delete(){

    }

    public Tag find(String name){

        List<Tag> tags = DataSupport.where("name = ?", name).find(Tag.class);

        if (tags.size()>0){
            return tags.get(0);
        }else {

            return null;

        }

    }


}
