package com.test.revise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "com.test.revise.extra.REPLY";
    private EditText replyEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Log.d(LOG_TAG,"onCreate");
        String message = intent.getStringExtra(BasicActivity.EXTRA_MESSAGE);
        TextView displayTextView = (TextView) findViewById(R.id.displayText);
        displayTextView.append(message + "\n");
        replyEditText = (EditText) findViewById(R.id.replyText);
        System.out.println(message);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");

    }

    public void revertBasic(View view) {
        Log.d(LOG_TAG, "Reply Clicked");
        Intent replyIntent = new Intent(this, BasicActivity.class);
        String reply = replyEditText.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG,"SecondActivity End");
        finish();

    }
}
