package com.example.findtoheal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(v -> {

            String recheck = email.getText().toString();
            String pass = password.getText().toString();
            mAuth=FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(recheck,pass).addOnCompleteListener(MainActivity.this, task -> {
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();

                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, dashboard.class);
                    intent.putExtra("uuid",user.getUid());
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            });
        });
        TextView signup = findViewById(R.id.SignupLogin);
        signup.setOnClickListener(v -> getsignup());
    }

    private void getsignup() {
        Intent intent = new Intent(MainActivity.this, signup.class);
        startActivity(intent);
        finish();
    }
}
