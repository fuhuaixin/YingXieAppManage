package com.example.manage.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;

import com.example.manage.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class BarChartUtils {

    private static BarChartUtils barChartUtil;
    private ArrayList<BarEntry> yValues =new ArrayList<>();
    private BarData mBarData;
    private BarDataSet barDataSet;
    private Context mContext;
    public static BarChartUtils getBarChart(){
        if( barChartUtil==null){
            barChartUtil=new BarChartUtils();
        }
        return  barChartUtil;
    }

    public void setBarChart(BarChart barChart, int type, ArrayList<BarEntry> yValues, Context context){
        this.yValues =yValues;
        mContext =context;
        // y 轴数据集
        if (type==1){

            barDataSet = new BarDataSet(yValues, "水量");
            barDataSet.setColor(mContext.getResources().getColor(R.color.war));
        }else if (type==2){

            // y 轴数据集
            barDataSet = new BarDataSet(yValues, "电量");

            barDataSet.setColor(mContext.getResources().getColor(R.color.ele));

        }


        // 2.0 ---- mBarData = new BarData(xValues, barDataSet);
        mBarData = new BarData(barDataSet);
        barChart.setData(mBarData);
//        mBarChart.invalidate();

        initBarChart(barChart);
    }

    private void initBarChart(BarChart mBarChart) {
        mBarChart.setDrawBarShadow(false);
        // 不显示图例
        Legend legend = mBarChart.getLegend();
        legend.setEnabled(false);

        Matrix matrix = new Matrix();
        // x轴缩放1.5倍
//        matrix.postScale(1.5f, 1f);
        // 在图表动画显示之前进行缩放
        mBarChart.getViewPortHandler().refresh(matrix, mBarChart, false);
        // x轴执行动画
        mBarChart.animateX(2000);
        mBarChart.invalidate();
        // 设置 条形图 简介
        Description description = new Description();
        // 可以自定义 位置
        // description.setPosition(200, 200);
        // 也可以 根据 X 轴，Y 轴进行偏移量设置
//        description.setXOffset(50f);
//        description.setYOffset(10f);
        description.setText("");
        mBarChart.setDescription(description);
        // 设置 是否可以缩放
        mBarChart.setScaleEnabled(false);
        // 设置 柱子的宽度
//        mBarData.setBarWidth(2f);

        // 获取 x 轴
        XAxis xAxis = mBarChart.getXAxis();
        // 设置 x 轴显示位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // 取消 垂直 网格线
        xAxis.setDrawGridLines(false);
        // 设置 x 轴 坐标旋转角度
//        xAxis.setLabelRotationAngle(10f);
        // 设置 x 轴 坐标字体大小
        xAxis.setTextSize(10f);
        // 设置 x 坐标轴 颜色
//        xAxis.setAxisLineColor(Color.RED);
        // 设置 x 坐标轴 宽度
        xAxis.setAxisLineWidth(2f);
        // 设置 x轴 的刻度数量
        xAxis.setLabelCount(10);

        //设置从20开始
//        xAxis.setAxisMinimum(1f);

        // 获取 右边 y 轴
        YAxis mRAxis = mBarChart.getAxisRight();
        // 隐藏 右边 Y 轴
        mRAxis.setEnabled(false);
        // 获取 左边 Y轴
        YAxis mLAxis = mBarChart.getAxisLeft();
        // 取消 左边 Y轴 坐标线
        mLAxis.setDrawAxisLine(true);
        // 取消 横向 网格线
        mLAxis.setDrawGridLines(true);
        // 设置 Y轴 的刻度数量
        mLAxis.setLabelCount(6);
        //设置从0开始
        mLAxis.setAxisMinimum(0f);

    }
}
