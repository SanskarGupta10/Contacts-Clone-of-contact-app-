package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {
  public TextView textView3, textView6;
  public ImageView imageView4;
  public Button button6,button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView3 = findViewById(R.id.textView3);
        textView6 = findViewById(R.id.textView6);
        imageView4 = findViewById(R.id.imageView4);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        Intent intent = getIntent();
        String finalName = intent.getStringExtra(MainActivity2.EXTRA_NAME);
        textView3.setText(finalName);
        String finPhoneno = intent.getStringExtra(MainActivity2.EXTRA_PHONE_NO);
        textView6.setText(finPhoneno);




    }
    public void call(View view){
        String dialNum = textView6.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + dialNum));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void mail(View view){
       Intent intent = new Intent(this,MainActivity6.class);
       startActivity(intent);
    }
}