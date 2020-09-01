package math.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class BarGraph extends AppCompatActivity {

    Button viewBar, savePairs, resetPairs;
    EditText x,y,label;
    public static int flag = 0, count = 0;

    public static ArrayList<String> arrayListX = new ArrayList<String>(10);
    public static ArrayList<String> arrayListY = new ArrayList<String>(10);

    public static String labelName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        viewBar = (Button) findViewById(R.id.barInfoBtn);
        savePairs = (Button) findViewById(R.id.saveBarBtn);
        resetPairs = (Button) findViewById(R.id.resetBarBtn);
        x = (EditText) findViewById(R.id.xET);
        y = (EditText) findViewById(R.id.yET);
        label = (EditText) findViewById(R.id.labelET);


        resetPairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListX.clear();
                arrayListY.clear();
                x.setText("");
                y.setText("");
                flag = 0;
                count = 0;
                Toast.makeText(getApplicationContext(),"all X , Y removed.",Toast.LENGTH_SHORT).show();
            }
        });

        viewBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BarGraph.this,MyBarView.class);
                startActivity(intent);
            }
        });

        savePairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(x.getText().toString().isEmpty() || y.getText().toString().isEmpty() || count > 9)
                {
                    Toast.makeText(getApplicationContext(),"both X , Y must be added! 10 pairs max.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    arrayListX.add(x.getText().toString());
                    arrayListY.add(y.getText().toString());

                    labelName = label.getText().toString();

                    x.setText("");
                    y.setText("");

                    flag = 1;
                    count++;
                    Toast.makeText(getApplicationContext(),"X , Y added.",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}