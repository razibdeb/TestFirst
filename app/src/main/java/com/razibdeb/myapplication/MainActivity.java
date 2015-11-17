package com.razibdeb.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {

    Button buttonTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"Welcome", Toast.LENGTH_LONG).show();
        Log.d("RAZIB", "happytext");

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        try {
            Parse.initialize(this, "MkQW1Ekz81HipGeAchKttJqfZPjwakB762ArwQtC", "Rx7ioN2vY04gTxLwhgmTBdXTKFCv05itfoeEbsPJ");
        }
        catch (Exception ex)
        {
            Log.d("RAZIB", "ERROR==================================");
            Log.d("RAZIB", ex.toString());
        }
        buttonTest = (Button) findViewById(R.id.buttonTest);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("foo", "bar");
                testObject.saveInBackground();
            }
        });
    }
}
