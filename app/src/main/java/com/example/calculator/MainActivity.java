package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_number_1, et_number_2;
    RadioButton rb_addition, rb_substraction, rb_multiplication, rb_division;
    Button btn_calculate, btn_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_number_1 = findViewById(R.id.et_number_1);
        et_number_2 = findViewById(R.id.et_number_2);
        rb_addition = findViewById(R.id.rb_addition);
        rb_substraction = findViewById(R.id.rb_substraction);
        rb_multiplication = findViewById(R.id.rb_multiplication);
        rb_division = findViewById(R.id.rb_division);
        btn_calculate = findViewById(R.id.btn_calculate);
        btn_about = findViewById(R.id.btn_about);

        rb_addition.setChecked(true);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double number1 = Double.parseDouble(et_number_1.getText().toString());
                Double number2 = Double.parseDouble(et_number_2.getText().toString());
                Double result = 0d;

                if (rb_addition.isChecked())
                    result = number1 + number2;
                else if (rb_substraction.isChecked())
                    result = number1 - number2;
                if (rb_multiplication.isChecked())
                    result = number1 * number2;
                if (rb_division.isChecked()) {
                    // ToDo: Show Toast when number2 = 0
                    if (number2 == 0) return;

                    result = number1 / number2;
                }

                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
        });

        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);

                startActivity(intent);
            }
        });
    }
}