package com.example.manage.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;

import com.example.manage.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;

public class PieChartUtil {
    //设置各区域颜色
    public final int[] PIE_COLORS = {
            Color.rgb(50, 208, 254), Color.rgb(72, 229, 41), Color.rgb(254, 119, 53),
            Color.rgb(255, 164, 29), Color.rgb(157, 80, 253), Color.rgb(251, 215, 191),
            Color.rgb(237, 189, 189), Color.rgb(172, 217, 243)
    };
    private static PieChartUtil pieChartUtil;
    private List<PieEntry> entries;
    private Context mContext;

    public static PieChartUtil getPitChart() {
        if (pieChartUtil == null) {
            pieChartUtil = new PieChartUtil();
        }
        return pieChartUtil;
    }


    public void setPieChart(PieChart pieChart, ArrayList count, String title, boolean showLegend, Context context, int total) {
        mContext = context;
        pieChart.setUsePercentValues(true);//设置使用百分比（后续有详细介绍）
        pieChart.getDescription().setEnabled(false);//设置描述
        pieChart.setRotationEnabled(false);//是否可以旋转
        pieChart.setHighlightPerTapEnabled(true);//点击是否放大
        pieChart.setDrawCenterText(true);//设置绘制环中文字
        pieChart.setDrawEntryLabels(true);
        //这个方法为true就是环形图，为false就是饼图
        pieChart.setDrawHoleEnabled(true);//环形

        pieChart.setExtraOffsets(0, 0, 0, 0); //设置边距
        // 0表示摩擦最大，基本上一滑就停
        // 1表示没有摩擦，会自动转化为0.9999,及其顺滑
        pieChart.setDragDecelerationFrictionCoef(0.35f);//设置滑动时的摩擦系数（值越小摩擦系数越大）
        pieChart.setCenterText(generateCenterSpannableText(total));//设置环中的文字
        pieChart.setCenterTextSize(15f);//设置环中文字的大小
        pieChart.setCenterTextColor(PIE_COLORS[2]);
        pieChart.setRotationAngle(130f);//设置旋转角度

        pieChart.setTransparentCircleRadius(0f);//设置半透明圆环的半径,看着就有一种立体的感觉
        //设置环形中间空白颜色是白色
        pieChart.setHoleColor(Color.TRANSPARENT);
        //设置半透明圆环的颜色
        pieChart.setTransparentCircleColor(Color.WHITE);
        //设置半透明圆环的透明度
        pieChart.setTransparentCircleAlpha(110);

        //图例设置
        Legend legend = pieChart.getLegend();
        if (showLegend) {
            legend.setEnabled(true);//是否显示图例
            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);//图例相对于图表横向的位置
            legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);//图例相对于图表纵向的位置
            legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);//图例显示的方向
            legend.setDrawInside(false);
            legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);//方向
        } else {
            legend.setEnabled(false);
        }

        //设置饼图数据
        setPieChartData(pieChart, count);

        pieChart.animateX(1500, Easing.EaseInOutQuad);//数据显示动画

    }

    //设置饼图数据
    private void setPieChartData(PieChart pieChart, ArrayList count) {
        entries = new ArrayList<>();
        for (int i = 0; i < count.size(); i++) {
            entries.add(new PieEntry(Float.valueOf(count.get(i).toString())));
        }

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setSliceSpace(0f);//设置饼块之间的间隔
        dataSet.setSelectionShift(3f);//设置饼块选中时偏离饼图中心的距离
        dataSet.setColors(PIE_COLORS);//设置饼块的颜色
        dataSet.setValueTextSize(5f);
        //设置数据显示方式有见图
        dataSet.setValueLinePart1OffsetPercentage(100f);//数据连接线距图形片内部边界的距离，为百分数
        dataSet.setValueLinePart1Length(0.3f);
        dataSet.setValueLinePart2Length(0.4f);
        dataSet.setValueLineColor(PIE_COLORS[3]);//设置连接线的颜色
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);//y轴数据显示在饼图内/外
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);//x轴数据显示在饼图内/外

        PieData pieData = new PieData(dataSet);
        pieData.setValueFormatter(new PercentFormatter(pieChart));
        pieData.setValueTextSize(12f);
        pieData.setValueTextColor(Color.BLACK);

        pieChart.setData(pieData);
        pieChart.highlightValues(null);
        pieChart.invalidate();
    }

    private SpannableString generateCenterSpannableText(int tatol) {
        SpannableString s = new SpannableString("总数\n" + tatol);
        Log.e("fhxx", "s的长度" + s.length());
        s.setSpan(new RelativeSizeSpan(0.8f), 0, 2, 0);
//        s.setSpan(new StyleSpan(Typeface.NORMAL), 0, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 0, 2, 0);
        s.setSpan(new RelativeSizeSpan(1.3f), 2, s.length(), 0);
//        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 4, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.light_blue)), s.length() - 4, s.length(), 0);
        return s;
    }

}