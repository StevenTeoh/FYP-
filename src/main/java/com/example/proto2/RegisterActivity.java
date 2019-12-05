package com.example.proto2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText Email;
    EditText Password;
    EditText username;
    Button Register;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        username = findViewById(R.id.etUserName);
        Register = findViewById(R.id.btnRegister);

        firebaseAuth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    String UserEmail = Email.getText().toString();
                    String UserPassword = Password.getText().toString();

                    firebaseAuth.createUserWithEmailAndPassword(UserEmail, UserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this,"Registration SuccessFull",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                            }
                            else{
                                Toast.makeText(RegisterActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }

    private Boolean validate(){
        Boolean result = false;

        String Ename = username.getText().toString();
        String Epassword = Password.getText().toString();
        String Eemail = Email.getText().toString();

        if(Ename.isEmpty() || Epassword.isEmpty() || Eemail.isEmpty()){
            Toast.makeText(this,"Please Enter all deatils! ",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result = true;
        }
        return result;
    }
}
