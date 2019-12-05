package com.example.proto2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private Button RegNow;
    private Button ToHome;
    private EditText LoginEmail;
    private EditText LoginPassword;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ToHome = findViewById(R.id.btnSignIn);
        RegNow = findViewById(R.id.btnRegister);
        LoginEmail = findViewById(R.id.lgEmail);
        LoginPassword = findViewById(R.id.lgPassword);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        ToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(LoginEmail.getText().toString(),LoginPassword.getText().toString());
            }
        });

        RegNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent (LoginActivity.this,RegisterActivity.class);
                startActivity(I);
            }
        });
    }

    public void validate(String Uname, String Upassword){

        firebaseAuth.signInWithEmailAndPassword(Uname,Upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Intent I = new Intent(LoginActivity.this, NavigationActivity.class);
                    startActivity(I);
                    Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
