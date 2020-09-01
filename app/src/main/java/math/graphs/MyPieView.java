package math.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MyPieView extends AppCompatActivity {

    PieGraph pieGraph;

    int myValue,i=0;
    String myLabel;


    int count = pieGraph.count;
    int flag = pieGraph.flag;

    String pieName = "Example";

    ArrayList<PieEntry> arrayList = new ArrayList<PieEntry>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pie_view);

        PieChart pieChart = findViewById(R.id.pieGraph);

        if(flag == 1)
        {
            for(i = 0;i < count;i++)
            {
                myValue = Integer.parseInt(pieGraph.arrayListValue.get(i));
                myLabel = pieGraph.arrayListLabel.get(i).toString();

                arrayList.add(new PieEntry(myValue,myLabel));
            }

            pieName = pieGraph.PieName;

            PieDataSet dataSet = new PieDataSet(arrayList,pieName);
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            dataSet.setValueTextColor(Color.BLACK);
            dataSet.setValueTextSize(16f);

            PieData pieData = new PieData(dataSet);

            pieChart.setData(pieData);
            pieChart.getDescription().setEnabled(false);
            pieChart.setCenterText(pieName);
            pieChart.animate();
        }


        if(flag == 0)
        {
            arrayList.add(new PieEntry(5,"1st"));
            arrayList.add(new PieEntry(6,"2nd"));
            arrayList.add(new PieEntry(7,"3rd"));

            PieDataSet dataSet2 = new PieDataSet(arrayList,pieName);
            dataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
            dataSet2.setValueTextColor(Color.BLACK);
            dataSet2.setValueTextSize(16f);

            PieData pieData2 = new PieData(dataSet2);

            pieChart.setData(pieData2);
            pieChart.getDescription().setEnabled(false);
            pieChart.setCenterText(pieName);
            pieChart.animate();

        }
    }
}