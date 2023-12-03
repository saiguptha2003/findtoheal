package com.example.findtoheal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class options extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        ImageView cardioImageView = findViewById(R.id.cardio);
        ImageView endoImageView = findViewById(R.id.endo);
        ImageView oncImageView = findViewById(R.id.onc);
        ImageView respImageView = findViewById(R.id.resp);
        Button logout = findViewById(R.id.back);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(options.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        Button search= findViewById(R.id.search);
        search.setOnClickListener(v -> {
            Intent intent = new Intent(options.this, dashboard.class);
            startActivity(intent);
            finish();
        });

        cardioImageView.setOnClickListener(view -> openDoctorDetails("cardio"));
        endoImageView.setOnClickListener(view -> openDoctorDetails("endo"));
        oncImageView.setOnClickListener(view -> openDoctorDetails("onc"));
        respImageView.setOnClickListener(view -> openDoctorDetails("resp"));
    }

    private void openDoctorDetails(String specialty) {
        Intent intent = new Intent(this, display.class);
        intent.putExtra("SPECIALTY", specialty);
        startActivity(intent);
    }
}
