package com.example.utilsmoudle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class ChartActivity extends AppCompatActivity {

    private LinearLayout mChartLiner;

    private double[] values;
    private int[] colors;
    private DefaultRenderer mRenderer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        initDatas();
        initViews();
    }

    private void initViews() {

        mChartLiner = (LinearLayout) findViewById(R.id.chartline);

        GraphicalView view = ChartFactory.getPieChartView(this, buildCategorySeries("类别", values), mRenderer);
        // 设置背景
        view.setBackgroundColor(Color.WHITE);
        mChartLiner.addView(view);

    }

    private void initDatas() {

        values = new double[] { 12, 14, 11, 10, 19 };
        colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN };
        mRenderer = buildCategoryRenderer(colors);
        //设置右下角的放大缩小按钮
        mRenderer.setZoomButtonsVisible(true);
        mRenderer.setZoomEnabled(true);
        mRenderer.setChartTitleTextSize(20);
        mRenderer.setChartTitle("饼图");

    }
    /**
     *  构建数据
     * @param title
     * @param values
     * @return
     */
    private CategorySeries buildCategorySeries(String title, double[] values) {
        CategorySeries cc = new CategorySeries(title);
        for (int i = 0; i < values.length; i++) {
            cc.add("数据 " + i + " (" + values[i] + ")", values[i]);
        }
        return cc;
    }

    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLabelsColor(Color.BLACK);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[] { 20, 30, 15, 0 });
        // 构建颜色
        for (int i = 0; i < colors.length; i++) {
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
            renderer.addSeriesRenderer(seriesRenderer);
        }
        return renderer;
    }
}
