package com.wanching.setcolour;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class SelectColourActivity extends AppCompatActivity {

    private String color = "#ff0000";
    Intent selectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_colour);
        setTitle("Select Color Activity");

        final RadioGroup colors = (RadioGroup) findViewById(R.id.radio_group);
        final Button btnOk = (Button) findViewById(R.id.btn_ok);

        selectedColor = new Intent();

        colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.rbn_blue:
                        color = "#ff0000";
                        break;
                    case R.id.rbn_green:
                        color = "#0000ff";
                        break;
                    case R.id.rbn_yellow:
                        color = "#a52a2a";
                        break;
                    case R.id.rbn_grey:
                        color = "#00ff00";
                        break;
                    case R.id.rbn_red:
                        color = "#ffff00";
                        break;
                }

                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        selectedColor.putExtra("selectedColor", color);
                        setResult(RESULT_OK, selectedColor);
                        finish();
                    }
                });
            }
        });


    }
}
