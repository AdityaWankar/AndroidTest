package com.test.revise;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri != null){
            String uri_string = "URI: " + uri.toString();
            TextView textView = (TextView) findViewById(R.id.uri_message);
            textView.setText(uri_string);
        }
    }
}
