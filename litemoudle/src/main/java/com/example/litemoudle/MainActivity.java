package com.example.litemoudle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.litemoudle.dao.LogDao;
import com.example.litemoudle.dao.ProjectDao;
import com.example.litemoudle.modols.Log;
import com.example.litemoudle.modols.Project;
import com.example.litemoudle.modols.Tag;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button addProject,deleteProject;
    private Button addTag,updateTag;
    private Button addLog,deleteLog;
    private Button addScene;

    private Button mBtnFindlogByProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        addProject = findViewById(R.id.add_project);
        addTag = findViewById(R.id.add_tag);
        updateTag = findViewById(R.id.update_tag);
        addLog = findViewById(R.id.add_log);
        addScene = findViewById(R.id.add_scene);
        addProject.setOnClickListener(this);
        addTag.setOnClickListener(this);
        addLog.setOnClickListener(this);
        addScene.setOnClickListener(this);

        updateTag.setOnClickListener(this);

        deleteLog = findViewById(R.id.delete_log);

        deleteLog.setOnClickListener(this);


        deleteProject = findViewById(R.id.delete_project);
        deleteProject.setOnClickListener(this);

        mBtnFindlogByProject = findViewById(R.id.find_log_by_projectid);
        mBtnFindlogByProject.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.add_log:

                addLOgs();

                break;

            case R.id.add_project:

                addProjects();

                break;

            case R.id.add_scene:

                addScenes();

                break;

            case R.id.add_tag:

                addTags();

                break;

            case R.id.update_tag:

                updateTags();

                break;

            case R.id.delete_log:

                deletelogs();
                break;

            case R.id.delete_project:
                deleteprojects();
                break;

            case R.id.find_log_by_projectid:

                findlogbyProjectids(1);
                break;

        }

    }

    private void findlogbyProjectids(int projectid) {



    }


    private void updateTags() {

        String name = "london";
        List<Tag> tags = DataSupport.where("name = ?", name).find(Tag.class);
        if (tags.size() != 0){
            Tag tag = tags.get(0);
            tag.setName("吃屎");
            List<Tag> tagList = DataSupport.where("name = ?", "吃屎").find(Tag.class);
            if (tagList.size() == 0){
                tag.save();
            }else {
                Toast.makeText(this, "已经存在该标签", Toast.LENGTH_SHORT).show();
            }

        }


    }

    private void addTags() {

        Tag tag = new Tag();
        String name = "吃屁";
        tag.setName(name);


        List<Tag> tags = DataSupport.where("name = ?", name).find(Tag.class);
        if (tags == null || tags.size() == 0){
            tag.save();
        }

    }

    private void addScenes() {
    }

    private void addProjects() {

        Project project = new Project();
        project.setName("考雅思");
        project.save();
    }

    private void deleteprojects() {


        DataSupport.delete(Project.class,1);

    }

    private void addLOgs() {

        Log log = new Log();
        log.setContent("背单词");
        log.setLengthtime(1000);
        List<Project> projects = DataSupport.where("name = ?", "考雅思").find(Project.class);
        if(projects.size() > 0){

            Project project = projects.get(0);

           project.getLogs().add(log);

           project.update(1);

            log.setProject(project);
        }
        log.save();

    }


    private void deletelogs() {

        List<Log> logs = DataSupport.where("content = ?", "背单词").find(Log.class);
        if (logs.size()>0){

            logs.get(0).delete();

        }

    }
}
