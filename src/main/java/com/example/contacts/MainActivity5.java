package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.contacts.Contact.Contact;
import com.example.contacts.ty.Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
   public ListView listView;
   private ArrayList<String> contact= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        listView = findViewById(R.id.listView);
        Data db = new Data(MainActivity5.this);
        List<Contact> contactLi = db.getAllContacts();
        for(Contact c :contactLi){
            contact.add(c.getName() + "(" + c.getPhoneNumber() + ")");
        }
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contact);
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity5.this,"Your Contact is Saved !",Toast.LENGTH_SHORT).show();
            }
        });
    }
}