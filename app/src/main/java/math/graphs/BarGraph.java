package math.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BarGraph extends AppCompatActivity {

    Button viewBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        viewBar = (Button) findViewById(R.id.barInfoBtn);

        viewBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BarGraph.this,MyBarView.class);
                startActivity(intent);
            }
        });

    }
}