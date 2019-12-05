package com.example.proto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateUnitActivity extends AppCompatActivity {

    private EditText locate,rtype,rental,descrip;
    private Button camera,regNewunit;

    DatabaseReference reff;
    UserData userdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_unit);

        locate = findViewById(R.id.etRoomLocate);
        rtype = findViewById(R.id.etRoomType);
        rental = findViewById(R.id.etRoomPrice);
        descrip = findViewById(R.id.etRoomDescription);
        camera = findViewById(R.id.btnVrCamera);
        regNewunit = findViewById(R.id.btnNewUnit);

        userdata = new UserData();
        reff = FirebaseDatabase.getInstance().getReference().child("UserData");

        regNewunit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float Rprice = Float.parseFloat(rental.getText().toString());

                userdata.setLocation(locate.getText().toString());
                userdata.setRoomType(rtype.getText().toString());
                userdata.setRoomPrice(Rprice);
                userdata.setRoomDescription(descrip.getText().toString());

                reff.push().setValue(userdata);
                Toast.makeText(CreateUnitActivity.this,"New Unit Created!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CreateUnitActivity.this,ManageUnitActivity.class));
            }
        });
    }
}
