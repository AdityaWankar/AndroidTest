package com.test.revise;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class BasicActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String LOG_TAG = BasicActivity.class.getSimpleName();
    private EditText editTextView;
    private String spinnerLabel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){

        }
        setContentView(R.layout.activity_basic);
        Log.d(LOG_TAG,"onCreate");
        editTextView = (EditText) findViewById(R.id.editText);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        if (spinner != null){
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void showText(View view) {
        if (editTextView != null){
            String showString = (editTextView.getText().toString() + " - " + spinnerLabel);
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        spinnerLabel = adapterView.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(LOG_TAG, "Nothing Selected");

    }

    public void showAlert(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(BasicActivity.this);
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Sample message for Alert");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"OK Pressed", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Cancel Pressed", Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.show();
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "date_picker");
    }



    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "time_picker");

    }

    public void processDatePickerResult(int year, int month, int day){
        Log.d("LOG_TAG", "Date onDateSet");
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (day_string + "/" + month_string + "/" + year_string);
        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();
    }

    public void processTimePickerResult(int hourOfDay, int minute){
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        String timeMessage = (hour_string + ":" + minute_string);
        Toast.makeText(this, "Time: " + timeMessage, Toast.LENGTH_SHORT).show();
    }
}
