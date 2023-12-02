package com.example.findtoheal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class appointment extends AppCompatActivity {

    private EditText appointmentDateEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);

        appointmentDateEditText = findViewById(R.id.Apointmentdate);
        submitButton = findViewById(R.id.submit); // Replace with your actual button ID

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the EditText
                String appointmentDate = appointmentDateEditText.getText().toString();

                // Check if the input is not empty
                if (!appointmentDate.isEmpty()) {
                    // Display a toast message
                    Toast.makeText(appointment.this, "Appointment Date: " + appointmentDate, Toast.LENGTH_SHORT).show();

                    // Intent intent = new Intent(YourActivity.this, SuccessActivity.class);
                    // startActivity(intent);
                } else {
                    // If the input is empty, display an error toast
                    Toast.makeText(appointment.this, "Please enter a date", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(appointment.this, SuccessActivity.class);
                startActivity(intent);
            }
        });
    }
}
