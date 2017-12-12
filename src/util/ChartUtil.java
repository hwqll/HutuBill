package util;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import javax.swing.*;
import java.awt.*;

public class ChartUtil {
    /**
     * 得到最大值
     * @param sampleValues
     * @return
     */
    public static int max(double[] sampleValues){
        int max = 0;
        for (double d: sampleValues){
            if (max < d){
                max = (int)d;
            }
        }
        return max;
    }

    /**
     * 返回横坐标
     * @return
     */
    private static String[] sampleLabels(){
        String[] sampleLabels = new String[30];
        for (int i = 0; i < sampleLabels.length; i++){
            if (0 == i % 5){
                sampleLabels[i] = String.valueOf(i+ 1 + "日");
            }
        }
        return sampleLabels;
    }

    /**
     *
     * @return
     */
    private static double[] sampleValues(){
        double[] sampleValues = new double[30];
        for (int i = 0; i < sampleValues.length; i++){
            sampleValues[i] = (int)(Math.random() * 300);
        }
        return sampleValues;
    }
    public static Image getImage(int width, int height){
        //模拟样本数据
        double[] sampleValues = sampleValues();
        //下方显示的文字
        String[] sampleLabels = sampleLabels();
        int max = max(sampleValues);
        //数据颜色
        Color[] samplecolors = new Color[]{ColorUtil.blueColor};

        //柱状图
        BarChart barChart = new BarChart();
        //设置样本个数
        barChart.setSampleCount(sampleValues.length);
        //设置样本数据
        barChart.setSampleValues(0, sampleValues);
        //设置文字
        barChart.setSampleLabels(sampleLabels);
        //设置颜色
        barChart.setSampleColors(samplecolors);
        //设置取值范围
        barChart.setRange(0, max * 1.2);
        //设置背景横线
        barChart.setValueLinesOn(true);
        //显示文字
        barChart.setValueLabelsOn(true);
        //文字显示在下方
        barChart.setSampleLabelStyle(barChart.BELOW);
        //样本值的字体
        barChart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
        //显示图例说明
        barChart.setLegendOn(true);

        // 把图例说明放在左侧
        barChart.setLegendPosition(barChart.LEFT);
        // 图例说明中的文字
        barChart.setLegendLabels(new String[] { "月消费报表" });
        // 图例说明的字体
        barChart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
        // 下方文字的字体
        barChart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        // 图表中间背景颜色
        barChart.setChartBackground(Color.white);
        // 图表整体背景颜色
        barChart.setBackground(ColorUtil.backgroundColor);
        // 把图表转换为Image类型
        Image im = barChart.getImage(width, height);
        return im;
    }

    public static void main(String[] args) {
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        Image img = ChartUtil.getImage(400, 300);
        Icon icon = new ImageIcon(img);
        l.setIcon(icon);
        p.add(l);
        GUIUitl.showPanel(p);
    }

}
