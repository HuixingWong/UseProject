package com.example.utilsmoudle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

import java.text.NumberFormat;

public class ChartActivity extends AppCompatActivity {

    private LinearLayout mChartLiner;

    private double[] values;
    private int[] colors;
    private DefaultRenderer mRenderer;

    private XYMultipleSeriesRenderer xyRender = new XYMultipleSeriesRenderer();// 图表描绘器
    private XYMultipleSeriesDataset xyData = new XYMultipleSeriesDataset();// 图表数据集
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        initDatas();
//        generatebarChar();
        initViews();
    }

    private void initViews() {

        mChartLiner = (LinearLayout) findViewById(R.id.chartline);

        GraphicalView view = ChartFactory.getPieChartView(this, buildCategorySeries("类别", values), mRenderer);

//        GraphicalView barChartView = ChartFactory.getBarChartView(this,xyData, xyRender, BarChart.Type.DEFAULT);
//        barChartView.setBackgroundColor(Color.WHITE);
        // 设置背景
        view.setBackgroundColor(Color.WHITE);
        mChartLiner.addView(view);

    }

    /**
     * 初始化图表中的数据
     */
    private void initDatas() {

        values = new double[] { 12, 14, 11, 10, 19 };
        colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.BLACK, Color.CYAN };
        mRenderer = buildCategoryRenderer(colors);
        //设置右下角的放大缩小按钮
        mRenderer.setZoomButtonsVisible(false);
        mRenderer.setZoomEnabled(true);
        mRenderer.setChartTitleTextSize(20);
        mRenderer.setChartTitle("饼图");

    }

    private void generatebarChar(){

        for (int i=0;i<5;i++){
            XYSeries xySeries = new XYSeries("1",i+15);
            xyData.addSeries(xySeries);

            SimpleSeriesRenderer simpleSeriesRenderer = new SimpleSeriesRenderer();
            simpleSeriesRenderer.setColor(colors[i]);
            xyRender.addSeriesRenderer(simpleSeriesRenderer);
        }


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
