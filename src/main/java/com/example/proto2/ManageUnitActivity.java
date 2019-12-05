package com.example.proto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageUnitActivity extends AppCompatActivity {

    Button ToProfileHome;
    Button ToCreateUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_unit);

        ToProfileHome = findViewById(R.id.btnBackHome);
        ToCreateUnit = findViewById(R.id.btnCreateUnit);

        ToProfileHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ManageUnitActivity.this,NavigationActivity.class);
                startActivity(i);
            }
        });

        ToCreateUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ManageUnitActivity.this,CreateUnitActivity.class);
                startActivity(i);
            }
        });
    }
}
