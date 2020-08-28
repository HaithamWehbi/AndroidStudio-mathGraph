package math.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MyBarView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bar_view);

        BarChart barChart = findViewById(R.id.barGraph);

        ArrayList<BarEntry> arrayList = new ArrayList<>();
        arrayList.add(new BarEntry(2010,5));
        arrayList.add(new BarEntry(2011,6));
        arrayList.add(new BarEntry(2012,7));

        BarDataSet dataSet = new BarDataSet(arrayList, "TT label");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(16f);

        BarData barData = new BarData(dataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("TT description");
        barChart.animateY(2000);



    }
}