package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;


import com.example.contacts.Contact.Contact;
import com.example.contacts.ty.Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    public RecyclerView recycle;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> phoneno = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recycle = findViewById(R.id.recycle);
        recycle.setLayoutManager(new LinearLayoutManager(MainActivity3.this));
        Data db = new Data(MainActivity3.this);

         List<Contact> contacts = db.getAllContacts();
         for(Contact con : contacts){
               name.add(con.getName());
               phoneno.add(con.getPhoneNumber());
         }

    }
}