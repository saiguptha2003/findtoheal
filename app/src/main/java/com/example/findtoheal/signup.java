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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.atomic.AtomicBoolean;

public class signup extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText getEmail = (EditText) findViewById(R.id.email);
        EditText getPassword = (EditText) findViewById(R.id.password);
        EditText getConfirmPassword = (EditText) findViewById(R.id.repassword);
        Button submits = (Button) findViewById(R.id.Signup);
        TextView login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(v -> {

            login();
        });
        submits.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                if(getEmail.getText().toString().isEmpty() || getPassword.getText().toString().isEmpty() || getConfirmPassword.getText().toString().isEmpty()){
                    Toast.makeText(signup.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    getEmail.setText("");
                    getPassword.setText("");
                    getConfirmPassword.setText("");
                    getEmail.setBackground(getDrawable(R.drawable.redfeild));
                    getPassword.setBackground(getDrawable(R.drawable.redfeild));
                    getConfirmPassword.setBackground(getDrawable(R.drawable.redfeild));


                }
                else if(checkRePassword(getPassword.getText().toString(), getConfirmPassword.getText().toString())){
                    createUser(getEmail.getText().toString(), getPassword.getText().toString());
                    Toast.makeText(signup.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(signup.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                }
                else{
                    Toast.makeText(signup.this, "Password and Confirm Password are not same", Toast.LENGTH_SHORT).show();
                    getPassword.setText("");
                    getConfirmPassword.setText("");
                    getConfirmPassword.setBackground(getDrawable(R.drawable.redfeild));

                }
            }

        }
        );




    }

    private void createUser(String text, String text1) {
        mAuth=FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(text, text1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            TextView textView = (TextView) findViewById(R.id.email);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(signup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean checkRePassword(String text, String text1) {
        return text.equals(text1);
    }

    private void login() {
        Intent intent = new Intent(signup.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
