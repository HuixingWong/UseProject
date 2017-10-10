package com.example.utilsmoudle;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utilsmoudle.TouchUtils.TestCallback;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements TestCallback.OnFragmentInteractionListener {

    private TextView tv;
    private Button mXlsBtn;

    String[] str = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    String filename = "textExcel.xls";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        mXlsBtn = (Button) findViewById(R.id.white_xls_btn);
        mXlsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exportExcelFile();
            }
        });


        // 步骤1：获取FragmentManager
        FragmentManager fragmentManager = getFragmentManager();

        // 步骤2：获取FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        // 步骤3：创建需要添加的Fragment
        TestCallback testCallback = TestCallback.newInstance("123", "456");
        // 步骤4：动态添加fragment
        // 即将创建的fragment添加到Activity布局文件中定义的占位符中（FrameLayout）
        fragmentTransaction.add(R.id.container_a_c, testCallback);
        fragmentTransaction.commit();


    }
    public void exportExcelFile2(){
        int size = 10;
        Workbook wb = new HSSFWorkbook();
        Sheet sh = wb.createSheet();

        for(int rownum=0;rownum<size;rownum++){
            Row row = sh.createRow(rownum);
            for(int cellnum=0;cellnum<10;cellnum++){
                Cell cell = row.createCell(cellnum);
                cell.setCellValue(str[cellnum]);
            }
        }

        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            wb.write(fos);
            fos.close();
            Toast.makeText(getApplicationContext(),"导出成功",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void exportExcelFile() {
        int size = 10;
        Workbook wb = new HSSFWorkbook();
        Sheet sh = wb.createSheet();

        for (int rownum = 0; rownum < size; rownum++) {
            Row row = sh.createRow(rownum);
            for (int cellnum = 0; cellnum < 10; cellnum++) {
                Cell cell = row.createCell(cellnum);
                cell.setCellValue(str[cellnum]);
            }
        }

        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/abc.xls");
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            wb.write(fos);
            fos.close();
            Toast.makeText(getApplicationContext(), "导出成功", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * fragment向activity传递数据，在这个回调里面接收
     *
     * @param uri
     */

    @Override
    public void onFragmentInteraction(String uri) {

        tv.setText(uri);
    }
}
