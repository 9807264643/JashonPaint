package com.example.jonshonpaints.submitActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.jonshonpaints.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SubmitActivity extends AppCompatActivity {
    Spinner spinner_name;
    SpinnerAdapter adapter_name;
    private DatePicker datePicker;
    private int year, month, day;
    private Calendar calendar;
    EditText dateView;

    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        init();
//        adapter_name = ArrayAdapter.createFromResource(this, R.array.name, android.R.layout.simple_spinner_dropdown_item);
//        spinner_name.setAdapter(adapter_name);
        setDateTimeField();

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);




        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == dateView){
                    toDatePickerDialog.show();
                }

            }
        });


    }

    private void init()
    {
//        spinner_name = findViewById(R.id.sp_name);
        dateView = findViewById(R.id.ed_date);

    }

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                dateView.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }



}
