package com.example.uravn;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a = findViewById(R.id.a_inp);
                EditText b = findViewById(R.id.b_inp);
                EditText c = findViewById(R.id.c_inp);
                TextView otv = findViewById(R.id.otv);
                String solve;
                String solve2;
                if(a.getText().toString().equals("")||b.getText().toString().equals("")||c.getText().toString().equals("")){
                    otv.setTextColor(Color.RED);
                    otv.setText("Рикардо вами не доволен!\nХватит ломать приложение!");

                }else {
                    otv.setTextColor(Color.BLACK);
                    otv.setTextSize(21);
                    double a_d = Double.parseDouble(a.getText().toString());
                    double b_d = Double.parseDouble(b.getText().toString());
                    double c_d = Double.parseDouble(c.getText().toString());
                    double D = b_d*b_d-4*a_d*c_d;
                    if(D==0){
                        solve = String.format("%.2f", (-b_d+sqrt(D))/(2*a_d));
                        otv.setText(solve);

                    }
                    if(D>0){
                        solve = String.format("%.2f", (-b_d+sqrt(D))/(2*a_d));
                        solve2 = String.format("%.2f", (-b_d-sqrt(D))/(2*a_d));
                        otv.setText(solve+" ; "+ solve2);
                    }
                    if(D<0){
                        otv.setText("Нет решений");
                    }
                }
            }
        });
    }

}
