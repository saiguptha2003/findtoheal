package com.example.findtoheal;


import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Connection;

public class dashboard extends AppCompatActivity {
    private DatabaseReference mDatabase;
    Connection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        EditText Disease = findViewById(R.id.Search);
        Button search = findViewById(R.id.submit);
       TextView email = findViewById(R.id.Email);
        TextView hospital = findViewById(R.id.Hospital);
        TextView name = findViewById(R.id.Name);
        TextView specialty = findViewById(R.id.Specialist);
        TextView phone = findViewById(R.id.Phone);
        TextView f1= findViewById(R.id.f1);
        TextView f2= findViewById(R.id.f2);
        TextView f3= findViewById(R.id.f3);
        TextView f4= findViewById(R.id.f4);
        TextView f5= findViewById(R.id.f5);
        TextView dnf= findViewById(R.id.datanotfound);
        f1.setVisibility(View.INVISIBLE);
        f2.setVisibility(View.INVISIBLE);
        f3.setVisibility(View.INVISIBLE);
        f4.setVisibility(View.INVISIBLE);
        f5.setVisibility(View.INVISIBLE);
        dnf.setVisibility(View.INVISIBLE);
        Button appoint = findViewById(R.id.appoint);
        appoint.setVisibility(View.INVISIBLE);
        appoint.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, appointment.class);
                startActivity(intent);
                finish();
            }
        });


        search.setOnClickListener(v -> {
            getInformation(Disease.getText().toString(), new DataCallback() {
                @Override
                public void onDataReceived(doctor doctorData) {
                    if (doctorData != null) {
                        dnf.setVisibility(View.INVISIBLE);
                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.VISIBLE);
                        f3.setVisibility(View.VISIBLE);
                        f4.setVisibility(View.VISIBLE);
                        f5.setVisibility(View.VISIBLE);
                        appoint.setVisibility(View.VISIBLE);
                        // Update the TextViews with the retrieved data
                        email.setText(doctorData.getEmail());
                        hospital.setText(doctorData.getHospital());
                        name.setText(doctorData.getName());
                        specialty.setText(doctorData.getSpecialty());
                        phone.setText(doctorData.getPhone());
                    } else {
                        dnf.setVisibility(View.VISIBLE);

                        // Handle the case when no data is found
                        Toast.makeText(getApplicationContext(), "Data not found", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });

    }
    public void getInformation(String Disease, DataCallback callback) {
        Disease = toCamelCase(Disease);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("diseases");

        databaseReference.orderByChild("name").equalTo(Disease).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        disease diseaseData = snapshot.getValue(disease.class);
                        if (diseaseData != null) {
                            doctor doctorData = diseaseData.getDoctor();
                            callback.onDataReceived(doctorData);
                        }
                    }
                } else {
                    callback.onDataReceived(null); // No data found
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callback.onDataReceived(null); // Error occurred
            }
        });
    }
    public static String toCamelCase(final String init) {
        if (init == null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());

        for (final String word : init.split(" ")) {
            if (!word.isEmpty()) {
                ret.append(Character.toUpperCase(word.charAt(0)));
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length() == init.length()))
                ret.append(" ");
        }

        return ret.toString();
    }


}



