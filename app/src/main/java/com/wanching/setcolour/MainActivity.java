package com.wanching.setcolour;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int SELECTOR_CONST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSelectColor(View view) {
        Intent myIntent = new Intent(MainActivity.this, SelectColourActivity.class);
        startActivityForResult(myIntent, SELECTOR_CONST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode){
            case SELECTOR_CONST:
                if (resultCode == RESULT_OK){
                    String color = intent.getExtras().getString("selectedColor");
                    findViewById(R.id.colour_box).setBackgroundColor(Color.parseColor(color));
                }
        }
    }
}
