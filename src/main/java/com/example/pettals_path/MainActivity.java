package com.example.pettals_path;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText et1, et2, et3, et4, et5;
        Button b1;

        et1 = findViewById(R.id.name);
        et2 = findViewById(R.id.phone);
        et3 = findViewById(R.id.email);
        et4 = findViewById(R.id.address);
        et5 = findViewById(R.id.dob);
        b1 = findViewById(R.id.register);

        String name = et1.getText().toString();
        String phone = et2.getText().toString();
        String email = et3.getText().toString();
        String address = et4.getText().toString();
        String dob = et5.getText().toString();

        et5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        et5.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }

                }, year, month, day);
                datePickerDialog.show();
            }
        });

        b1.setOnClickListener(v -> {

            if (DetailsValidator.isEmailValid(et3.getText().toString()) && DetailsValidator.isPhoneValid(et2.getText().toString())) {

                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            else if (name.isEmpty()||phone.isEmpty()||email.isEmpty()||address.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wrong Details", Toast.LENGTH_SHORT).show();
                }


                });
    }

}

