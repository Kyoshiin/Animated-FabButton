package com.example.animatedfab;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity{

    boolean isRotate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = findViewById(R.id.fab);
        final FloatingActionButton fabRegHosp = findViewById(R.id.fabRegHospital);
        final FloatingActionButton fabAddClinc = findViewById(R.id.fabAddClinic);
        final LinearLayout RegHospital = findViewById(R.id.RegHospLayout);
        final LinearLayout AddClinic = findViewById(R.id.addClinicLayout);

        ViewAnimation.init(RegHospital);
        ViewAnimation.init(AddClinic);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRotate = ViewAnimation.rotateFab(v, !isRotate);
                if(isRotate){
                    ViewAnimation.showIn(AddClinic);
                    ViewAnimation.showIn(RegHospital);
                    fabAddClinc.setOnClickListener(listener);
                    fabRegHosp.setOnClickListener(listener);
//                    Toast.makeText(getApplicationContext(),"Pop out",Toast.LENGTH_SHORT).show();

                }else{
                    ViewAnimation.showOut(AddClinic);
                    ViewAnimation.showOut(RegHospital);
//                    Toast.makeText(getApplicationContext(),"Hide in",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.fabRegHospital:
                    Snackbar.make(view,"Opening Added RegHospital", Snackbar.LENGTH_SHORT).show();


                case R.id.fabAddClinic:
                    Snackbar.make(view,"Opening Add Clinic", Snackbar.LENGTH_SHORT).show();

            }
        }
    };


}