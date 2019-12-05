package com.example.proto2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    private Button btnToUnit;
    private Button Logout;

    private FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_profile,container,false);

        btnToUnit = v.findViewById(R.id.btnManageUnit);
        Logout = v.findViewById(R.id.btnLogout);
        firebaseAuth =FirebaseAuth.getInstance();

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                startActivity(new Intent(getActivity(),LoginActivity.class));
                Toast.makeText(getActivity(), "Logout Successful!", Toast.LENGTH_SHORT).show();
            }
        });

        btnToUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),ManageUnitActivity.class));
            }
        });

        return v;
    }
}
