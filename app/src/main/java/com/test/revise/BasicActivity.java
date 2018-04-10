package com.test.revise;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class BasicActivity extends AppCompatActivity {

    private static final String LOG_TAG = BasicActivity.class.getSimpleName();
    private EditText websiteText;
    private EditText locationText;
    private EditText shareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        Log.d(LOG_TAG,"onCreate");
        websiteText = (EditText) findViewById(R.id.website_editText);
        locationText = (EditText) findViewById(R.id.location_editText);
        shareText = (EditText) findViewById(R.id.share_editText);

    }

    public void openWebsite(View view) {
        String url = websiteText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents","Can't handle this");
        }
    }

    public void openLocation(View view) {
        String loc = locationText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents","Can't handle this");
        }
    }

    public void shareText(View view) {
        String txt = shareText.getText().toString();
        String mimeText = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeText)
                .setText(txt)
                .setChooserTitle("Share this text with: ")
                .startChooser();
    }
}
