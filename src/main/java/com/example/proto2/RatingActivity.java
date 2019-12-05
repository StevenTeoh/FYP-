package com.example.proto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    Button btn;
    RatingBar rBar;

    float userRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        btn = findViewById(R.id.btnToRate);
        rBar = findViewById(R.id.ratingBar);

        rBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                int rating = (int) v;
                String message = null;

                userRating = rBar.getRating();

                switch(rating){
                    case 1:
                        message = "Sorry to hear that! Please send me you feedback!";
                        break;
                    case 2:
                        message = "It seems that more improvements is needed.Kindly send me your feedback";
                        break;
                    case 3:
                        message = "Average thanks! Any suggestions is welcomed!";
                        break;
                    case 4:
                        message = "Thank you! We would like to make it better!";
                        break;
                    case 5:
                        message = "Great to serve you fully!";
                        break;
                }

                Toast.makeText(RatingActivity.this, message,Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(RatingActivity.this,"Your rating of " + userRating + " will be recorded! Thanks!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(RatingActivity.this,NavigationActivity.class);
                startActivity(i);
            }
        });
    }
}
