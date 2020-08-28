package math.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PieGraph extends AppCompatActivity {

    Button viewPie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_graph);

        viewPie = (Button) findViewById(R.id.pieInfoBtn);

        viewPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PieGraph.this,MyPieView.class);
                startActivity(intent);
            }
        });

    }
}