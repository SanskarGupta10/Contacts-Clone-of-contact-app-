package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity6 extends AppCompatActivity {
    public Button button9;
    public EditText edit6;
    public EditText edit7;
    public EditText edit8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        button9 = findViewById(R.id.button9);
        edit6 = findViewById(R.id.edit6);
        edit7 = findViewById(R.id.edit7);
        edit8 = findViewById(R.id.edit8);
    }

    public void open(View view) {
        String emailsend = edit6.getText().toString();
        String emailsubject = edit8.getText().toString();
        String emailbody = edit7.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        //use for non attachment of any file
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, emailsend);
        intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
        intent.putExtra(Intent.EXTRA_TEXT, emailbody);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}