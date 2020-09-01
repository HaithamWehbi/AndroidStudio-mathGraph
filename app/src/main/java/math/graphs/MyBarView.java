package math.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MyBarView extends AppCompatActivity {


    BarGraph barGraph;

    int x,y,i=0;

    int count = barGraph.count;
    int flag = barGraph.flag;

    String label;

    ArrayList<BarEntry> arrayList = new ArrayList<BarEntry>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bar_view);

        BarChart barChart = findViewById(R.id.barGraph);

        if(flag == 1)
        {
            for (i = 0;i < count;i++)
            {
                x = Integer.parseInt(barGraph.arrayListX.get(i));
                y = Integer.parseInt(barGraph.arrayListY.get(i));

                arrayList.add(new BarEntry(x,y));
            }

            label = barGraph.labelName;

            BarDataSet dataSet2 = new BarDataSet(arrayList,label);
            dataSet2.setColors(ColorTemplate.MATERIAL_COLORS);
            dataSet2.setValueTextColor(Color.BLACK);
            dataSet2.setValueTextSize(16f);

            BarData barData2 = new BarData(dataSet2);

            barChart.setFitBars(true);
            barChart.setData(barData2);
            barChart.getDescription().setText("");
            barChart.animateY(2000);

        }


        if(flag == 0)
        {
            arrayList.add(new BarEntry(2010,5));
            arrayList.add(new BarEntry(2011,6));
            arrayList.add(new BarEntry(2012,7));

            BarDataSet dataSet = new BarDataSet(arrayList, "Example label");
            dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
            dataSet.setValueTextColor(Color.BLACK);
            dataSet.setValueTextSize(16f);

            BarData barData = new BarData(dataSet);

            barChart.getDescription().setText("Example");
            barChart.setFitBars(true);
            barChart.setData(barData);
            barChart.animateY(2000);
        }
    }
}