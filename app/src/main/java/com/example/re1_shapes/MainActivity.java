package com.example.re1_shapes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_rect_width;
    EditText et_rect_height;
    EditText et_triangle_base;
    EditText et_triangle_height;
    EditText et_circle_radius;
    TextView tv_res;
    Button btn_calculate;
    Spinner sp;
    double area=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_rect_width=findViewById(R.id.et_rect_width);
        et_rect_height=findViewById(R.id.et_rect_height);
        et_triangle_base=findViewById(R.id.et_triangle_base);
        et_triangle_height=findViewById(R.id.et_triangle_height);
        et_circle_radius=findViewById(R.id.et_circle_radius);
        tv_res=findViewById(R.id.tv_result);
        btn_calculate=findViewById(R.id.btn_calculate);
        sp=findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        et_rect_width.setVisibility(View.VISIBLE);
                        et_rect_height.setVisibility(View.VISIBLE);
                        et_circle_radius.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        et_circle_radius.setText("");
                        et_triangle_base.setText("");
//                        tv_res.setText("");
                        et_triangle_height.setText("");
                        break;
                    case 1:
                        et_rect_width.setVisibility(View.GONE);
                        et_rect_height.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.VISIBLE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        et_rect_width.setText("");
                        et_rect_height.setText("");
//                        tv_res.setText("");
                        et_triangle_base.setText("");
                        et_triangle_height.setText("");
                        break;
                    case 2:
                        et_rect_width.setVisibility(View.GONE);
                        et_rect_height.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.VISIBLE);
                        et_triangle_height.setVisibility(View.VISIBLE);
                        et_rect_width.setText("");
                        et_rect_height.setText("");
                        et_circle_radius.setText("");
//                        tv_res.setText("");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index=sp.getSelectedItemPosition();
                switch (index)
                {
                    case 0:
                        String w=et_rect_width.getText().toString();
                        String h=et_rect_height.getText().toString();
                        double width=Double.parseDouble(w);
                        double height=Double.parseDouble(h);
                        area=width*height;
                        break;
                    case 1:
                        String r=et_circle_radius.getText().toString();
                        double radius=Double.parseDouble(r);
                        area=Math.PI*Math.pow(radius,2);
                        break;
                    case 2:
                        String b=et_triangle_base.getText().toString();
                        String he=et_triangle_height.getText().toString();
                        double base=Double.parseDouble(b);
                        double het=Double.parseDouble(he);
                        area=0.5*base*het;
                        break;
                }
                tv_res.setText(area+"");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"welcome to our app",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"last area is "+area,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("res",tv_res.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String r=savedInstanceState.getString("res");
        tv_res.setText(r);
    }
}
