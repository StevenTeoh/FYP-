package com.example.proto2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class OthersFragment extends Fragment{

    private Button btnToabout, btnToRating, btnToFeedback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_others,container,false);

        btnToabout = v.findViewById(R.id.btnAboutUs);
        btnToRating = v.findViewById(R.id.btnRate);
        btnToFeedback = v.findViewById(R.id.btnFeedback);

        btnToabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),AboutUsActivity.class));
            }
        });

        btnToRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),RatingActivity.class));
            }
        });
        return v;
    }

}
