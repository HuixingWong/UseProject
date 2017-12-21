package com.example.litemoudle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.litemoudle.dao.ProjectDao;
import com.example.litemoudle.dao.SceneDao;
import com.example.litemoudle.dao.TagDao;
import com.example.litemoudle.modols.Log;
import com.example.litemoudle.modols.Project;
import com.example.litemoudle.modols.Scene;
import com.example.litemoudle.modols.Tag;

import org.litepal.crud.DataSupport;

import java.util.List;

public class AddDataActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mName,mStart,mLength,mContent,mScene,mRename,mAddTag,mAddProjec,mType;

    private Button mAdd,mDelete,mUpdate,mfind;
    private int DATATYPE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        initViews();
    }

    private void initViews() {

        mType = findViewById(R.id.type);
        mName = findViewById(R.id.name_et);
        mStart = findViewById(R.id.starttime_et);
        mLength = findViewById(R.id.timelength_et);
        mContent = findViewById(R.id.content_et);
        mScene = findViewById(R.id.scene_name_et);
        mRename = findViewById(R.id.rename_et);
        mAddTag = findViewById(R.id.add_tag);
        mAddProjec = findViewById(R.id.add_project);

        mAdd = findViewById(R.id.btn_add);
        mDelete = findViewById(R.id.btn_delete);
        mUpdate = findViewById(R.id.btn_update);
        mfind = findViewById(R.id.btn_find);

        mAdd.setOnClickListener(this);
        mDelete.setOnClickListener(this);
        mUpdate.setOnClickListener(this);
        mfind.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){


            case R.id.btn_add:

                getType();
                add();

                break;

            case R.id.btn_delete:
                getType();
                delete();

                TagDao tagDao = new TagDao();
                Tag tag = tagDao.find("study");
                if (tag != null){

                    DataSupport.delete(Tag.class,tag.getId());
                }


                break;

            case R.id.btn_update:
                getType();
                update();

                break;

            case R.id.btn_find:
                getType();
                find();
                Project project = DataSupport.find(Project.class, 6,true);
//                List<Log> logsbyProjectid = project.getLogsbyProjectid(4);


//                List<Tag> tagsByProjectid = project.getTagsByProjectid(4);
                List<Tag> tags = project.getTags();

                Toast.makeText(this, ""+tags.size()+tags.get(0).getName(), Toast.LENGTH_SHORT).show();



                break;

        }

    }

    private void getType(){
        String s = mType.getText().toString();
        if (s != null){
            try{

                int i = Integer.parseInt(s);
                DATATYPE = i;

            }catch (Exception e){
                Toast.makeText(this, "请输入正确的类型", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void find() {
        switch (DATATYPE){

            case 1:
                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

        }

    }

    private void update() {

        switch (DATATYPE){

            case 1:
                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

        }


    }

    private void delete() {
        switch (DATATYPE){

            case 1:
                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

        }


    }

    private void add() {

        String name = mName.getText().toString();

        String s = mLength.getText().toString();
        int timelenth = strToint(s);


         s = mStart.getText().toString();

        int starttime = strToint(s);


        String content = mContent.getText().toString();

        String scenename = mScene.getText().toString();


        String addtag = mAddTag.getText().toString();
        String addproject = mAddProjec.getText().toString();

        String rename = mRename.getText().toString();


        switch (DATATYPE){

            case 1:
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(this, "请输入名称", Toast.LENGTH_SHORT).show();
                    return;
                }
                ProjectDao projectDao = new ProjectDao();
                Project project = new Project();
                project.setName(name);
                if (null != addtag){
                   TagDao tagDao = new TagDao();
                    Tag tag = tagDao.find(addtag);
                    if (tag != null){
                        project.getTags().add(tag);
                    }
                }
                projectDao.add(project);
                break;

            case 2:
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(this, "请输入名称", Toast.LENGTH_SHORT).show();
                    return;
                }

                TagDao tagDao = new TagDao();
                Tag tag = new Tag();
                tag.setName(name);

                tagDao.add(tag);


                break;

            case 3:

                if (TextUtils.isEmpty(name)){
                    Toast.makeText(this, "请输入名称", Toast.LENGTH_SHORT).show();
                    return;
                }

                SceneDao sceneDao = new SceneDao();
                Scene scene = new Scene();
                scene.setName(name);
                sceneDao.add(scene);

                break;

            case 4:
                if (timelenth == 0){
                    Toast.makeText(this, "请输入记录时长", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (null == addproject){

                    Toast.makeText(this, "请设置项目", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log log = new Log();
                log.setLengthtime(timelenth);
                if (starttime != 0){

                    log.setStartime(starttime);
                }

                if (null != content){
                    log.setContent(content);
                }

                if (null != scenename){
//                    log.setScene_name(scenename);
                }

                ProjectDao projectDao1 = new ProjectDao();
                final Project firstProjectByName = projectDao1.findFirstProjectByName(addproject);
                log.setProject(firstProjectByName);

                firstProjectByName.getLogs().add(log);
                firstProjectByName.update(firstProjectByName.getId());

                log.save();

                break;

        }


    }


    private  int strToint(String str){


        try{

            int i = Integer.parseInt(str);
            return i;

        }catch (Exception e){

        }

        return 0;

    }


}
