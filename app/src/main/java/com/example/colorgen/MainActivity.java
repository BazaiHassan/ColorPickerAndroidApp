package com.example.colorgen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.colorgen.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarRed, seekBarGreen, seekBarBlue;
    private TextView txtRedCount;
    private TextView txtGreenCount;
    private TextView txtBlueCount;
    private TextView txtColorCode;
    private CardView colorScreen;
    private RadioButton rbRGB, rbHEX;
    private ImageView closeApp;
    private RelativeLayout rlRed,rlGreen,rlBlue;
    int valueRed, valueGreen, valueBlue;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        findViews();
        listener();
        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String txtSeekValue = String.valueOf(i);
                txtRedCount.setText(txtSeekValue);
                valueRed = i;
                binding.colorScreen.setCardBackgroundColor(Color.rgb(valueRed, valueGreen, valueBlue));
                binding.rlRed.setBackgroundColor(Color.rgb(valueRed,0,0));

                if (rbRGB.isChecked()) {
                    txtColorCode.setText(String.valueOf(Color.rgb(valueRed, valueGreen, valueBlue)));
                } else if (rbHEX.isChecked()) {
                    txtColorCode.setText(String.format("#%02X%02X%02X",valueRed, valueGreen, valueBlue));
                } else {
                    txtColorCode.setText("Please Select RGB or HEX");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String txtSeekValue = String.valueOf(i);
                txtGreenCount.setText(txtSeekValue);
                valueGreen = i;
                binding.colorScreen.setCardBackgroundColor(Color.rgb(valueRed, valueGreen, valueBlue));
                binding.rlGreen.setBackgroundColor(Color.rgb(0,valueGreen,0));

                if (rbRGB.isChecked()) {
                    txtColorCode.setText(String.valueOf(Color.rgb(valueRed, valueGreen, valueBlue)));
                } else if (rbHEX.isChecked()) {
                    txtColorCode.setText(String.format("#%02X%02X%02X",valueRed, valueGreen, valueBlue));
                } else {
                    txtColorCode.setText("Please Select RGB or HEX");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String txtSeekValue = String.valueOf(i);
                txtBlueCount.setText(txtSeekValue);
                valueBlue = i;
                binding.colorScreen.setCardBackgroundColor(Color.rgb(valueRed, valueGreen, valueBlue));
                binding.rlBlue.setBackgroundColor(Color.rgb(0,0,valueBlue));

                if (rbRGB.isChecked()) {
                    txtColorCode.setText(String.valueOf(Color.rgb(valueRed, valueGreen, valueBlue)));
                } else if (rbHEX.isChecked()) {
                    txtColorCode.setText(String.format("#%02X%02X%02X",valueRed, valueGreen, valueBlue));
                } else {
                    txtColorCode.setText("Please Select RGB or HEX");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void listener() {
        closeApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void findViews() {
        seekBarRed = findViewById(R.id.seek_red);
        seekBarGreen = findViewById(R.id.seek_green);
        seekBarBlue = findViewById(R.id.seek_blue);
        txtRedCount = findViewById(R.id.txt_red_count);
        txtGreenCount = findViewById(R.id.txt_green_count);
        txtBlueCount = findViewById(R.id.txt_blue_count);
        colorScreen = findViewById(R.id.color_screen);
        txtColorCode = findViewById(R.id.txt_color_code);
        rbRGB = findViewById(R.id.rb_rgb);
        rbHEX = findViewById(R.id.rb_hex);
        closeApp = findViewById(R.id.close_app);
        rlRed = findViewById(R.id.rl_red);
        rlGreen = findViewById(R.id.rl_green);
        rlBlue = findViewById(R.id.rl_blue);
        txtColorCode.setText("Please Select RGB or HEX");

    }


}