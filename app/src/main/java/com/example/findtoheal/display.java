package com.example.findtoheal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        Intent intent = getIntent();
        if (intent != null) {
            String specialty = intent.getStringExtra("SPECIALTY");
            if (specialty != null) {
                // Call a method to set TextViews based on the specialty
                setDoctorDetails(specialty);
            }
        }
    }

    private void setDoctorDetails(String specialty) {
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView groupOfWorkTextView = findViewById(R.id.groupOfWorkTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);
        TextView experienceTextView = findViewById(R.id.experienceTextView);

        // Example: Set dummy data based on specialty (Replace with your logic)
        switch (specialty) {
            case "cardio":
                nameTextView.setText("Dr. John Doe");
                groupOfWorkTextView.setText("Cardiologist");
                emailTextView.setText("john.doe@example.com");
                phoneTextView.setText("123-456-7890");
                experienceTextView.setText("10 years");
                break;
            case "endo":
                nameTextView.setText("Dr. Jane Doe");
                groupOfWorkTextView.setText("Endocrinologist");
                emailTextView.setText("asdfds@asdf.com");
                phoneTextView.setText("123-456-7890");
                experienceTextView.setText("10 years");
                break;
            case "resp":
                nameTextView.setText("Dr. Emily Smith");
                groupOfWorkTextView.setText("Endocrinologist");
                emailTextView.setText("emily.smith@example.com");
                phoneTextView.setText("987-654-3210");
                experienceTextView.setText("12 years");
                break;
            case "onc":
                nameTextView.setText("Dr. f Smith");
                groupOfWorkTextView.setText("Endocrinologist");
                emailTextView.setText("emily.smith@example.com");
                phoneTextView.setText("987-654-3210");
                experienceTextView.setText("12 years");
            default:
                break;
        }
    }
}
