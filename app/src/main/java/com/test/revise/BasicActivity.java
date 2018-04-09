package com.test.revise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.test.revise.MainActivity.EXTRA_REPLY;

public class BasicActivity extends AppCompatActivity {

    private static final String LOG_TAG = BasicActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.test.revise.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private TextView showTextView;
    private EditText sendEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sendEditText = (EditText) findViewById(R.id.sendText);
        showTextView = (TextView) findViewById(R.id.showText);
    }

    public void launchMain(View view) {

        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity.class);
        String message = sendEditText.getText().toString();
        System.out.println(1 + message);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(MainActivity.EXTRA_REPLY);
                showTextView.setText(reply);
            }
        }
    }
}
