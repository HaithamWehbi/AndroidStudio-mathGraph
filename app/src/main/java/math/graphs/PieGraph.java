package math.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PieGraph extends AppCompatActivity {

    Button viewPie, resetPie, savePie;
    EditText valueET, labelET, pieET;

    public static int flag = 0, count = 0;

    public static ArrayList<String> arrayListValue = new ArrayList<String>(10);
    public static ArrayList<String> arrayListLabel = new ArrayList<String>(10);

    public static String PieName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_graph);

        viewPie = (Button) findViewById(R.id.pieInfoBtn);
        resetPie = (Button) findViewById(R.id.resetPieBtn);
        savePie = (Button) findViewById(R.id.savePieBtn);
        valueET = (EditText) findViewById(R.id.valueET);
        labelET = (EditText) findViewById(R.id.labelET);
        pieET = (EditText) findViewById(R.id.pieNameET);

        viewPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PieGraph.this,MyPieView.class);
                startActivity(intent);
            }
        });

        resetPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListValue.clear();
                arrayListLabel.clear();
                valueET.setText("");
                labelET.setText("");
                flag = 0;
                count = 0;
                Toast.makeText(getApplicationContext(),"all Values , Labels removed.",Toast.LENGTH_SHORT).show();
            }
        });

        savePie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(valueET.getText().toString().isEmpty() || labelET.getText().toString().isEmpty() || count > 9)
                {
                    Toast.makeText(getApplicationContext(),"both X , Y must be added! 10 pairs max.",Toast.LENGTH_SHORT).show();
                    if(count > 9)
                    {
                        Toast.makeText(getApplicationContext(),"You already have max pairs.",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    arrayListValue.add(valueET.getText().toString());
                    arrayListLabel.add(labelET.getText().toString());

                    PieName = pieET.getText().toString();

                    valueET.setText("");
                    labelET.setText("");

                    flag = 1;
                    count++;
                    Toast.makeText(getApplicationContext(),"Value , Label added.",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}