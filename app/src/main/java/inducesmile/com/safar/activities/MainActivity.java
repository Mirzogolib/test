package inducesmile.com.safar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import inducesmile.com.safar.R;
import inducesmile.com.safar.service.Service;

public class MainActivity extends AppCompatActivity {

    Service service;
    String language;
    int id;
    String TAG= "TEST";
    CardView cardView;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView = (CardView) findViewById(R.id.cardView1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

    }


}
