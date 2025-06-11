package com.armanhossain.thehungryapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CardView startersCardView;
    CardView mainsCardView;
    CardView dessertsCardView;
    TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        findViews();
    }

    private void findViews() {
        startersCardView = findViewById(R.id.cv_starters);
        mainsCardView = findViewById(R.id.cv_mains);
        dessertsCardView = findViewById(R.id.cv_desserts);
        emailTextView = findViewById(R.id.tv_restaurant_email);

        startersCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startersActivityIntent = new Intent(MainActivity.this, StarterActivity.class);
                startActivity(startersActivityIntent);
            }
        });

        mainsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainCoursesActivityIntent = new Intent(MainActivity.this, MainCourseActivity.class);
                startActivity(mainCoursesActivityIntent);
            }
        });

        dessertsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dessertActivityIntent = new Intent(MainActivity.this, DessertActivity.class);
                startActivity(dessertActivityIntent);
            }
        });

        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
                launchEmailAppIntent.setData(Uri.parse("mailto:armanhossain1190@gmail.com"));
//                launchEmailAppIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
//                launchEmailAppIntent.putExtra(Intent.EXTRA_SUBJECT, "Mail sent from Android App");
//                if (launchEmailAppIntent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(launchEmailAppIntent);
//                }
                startActivity(launchEmailAppIntent);
            }
        });
    }
}