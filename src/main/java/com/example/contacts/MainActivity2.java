package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.EditText;

import android.os.Bundle;
import android.widget.Toast;

import com.example.contacts.Contact.Contact;
import com.example.contacts.ty.Data;

import java.util.List;
 public class MainActivity2 extends AppCompatActivity {
   Button button2, button3, button4,button5;
   ImageView imageView2;
   EditText edit1,edit2;
   public static  final String EXTRA_NAME = "com.example.firstmul.extra.NAME";
     public static  final String EXTRA_PHONE_NO = "com.example.secondmul.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        imageView2= findViewById(R.id.imageView2);
        edit1 = findViewById(R.id.edit6);
        edit2 = findViewById(R.id.edit8);
        button5 = findViewById(R.id.button5);




    }
    public void save(View view){

        Toast.makeText(MainActivity2.this,"Saving the contact !",Toast.LENGTH_SHORT).show();
        Data db = new Data(MainActivity2.this);
        String aname = edit1.getText().toString();
        String aphoneno = edit2.getText().toString();
        if(!(aname.equals("") || aphoneno.equals(""))){
        Contact contact = new Contact();
        contact.setName(aname);
        contact.setPhoneNumber(aphoneno);
        db.addContact(contact);
        }
        else{
            Toast.makeText(MainActivity2.this,"Incomplete Info !",Toast.LENGTH_SHORT).show();
        }
    }
    public void show(View view){
        Intent intent =new Intent(this,MainActivity5.class);
         startActivity(intent);
    }

    public void search(View view){
        Data db = new Data(MainActivity2.this);
List<Contact> contacts = db.getAllContacts();
        String aname = edit1.getText().toString();
        String aphoneno = edit2.getText().toString();
        if(aname.equals("") && aphoneno.equals("")){
            Toast.makeText(MainActivity2.this,"Nothing to Search !",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity2.this,"Searching !",Toast.LENGTH_SHORT).show();
            for(Contact con : contacts){
                if(con.getName().equalsIgnoreCase(aname) && aphoneno.equals("")){

                    Intent intent = new Intent(this,MainActivity4.class);
                    String pname = aname;
                    String pphoneno = con.getPhoneNumber();
                     intent.putExtra(EXTRA_NAME,pname);
                     intent.putExtra(EXTRA_PHONE_NO,pphoneno);
                    startActivity(intent);

                }
                if(con.getPhoneNumber().equalsIgnoreCase(aphoneno) && aname.equals("")){

                    Intent intent = new Intent(this,MainActivity4.class);
                    String pname = con.getName();
                    String pphoneno = aphoneno;
                    intent.putExtra(EXTRA_NAME,pname);
                    intent.putExtra(EXTRA_PHONE_NO,pphoneno);
                    startActivity(intent);

                }
                if(con.getName().equalsIgnoreCase(aname) && con.getPhoneNumber().equalsIgnoreCase(aphoneno)){

                    Intent intent = new Intent(this,MainActivity4.class);
                    String pname = aname;
                    String pphoneno = aphoneno;
                    intent.putExtra(EXTRA_NAME,pname);
                    intent.putExtra(EXTRA_PHONE_NO,pphoneno);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(MainActivity2.this,"Contact not present !",Toast.LENGTH_SHORT).show();
                }

            }

        }

    }
    public void delete(View view){
        Data db = new Data(MainActivity2.this);
        List<Contact> contacts = db.getAllContacts();
        String aname = edit1.getText().toString();
        String aphoneno = edit2.getText().toString();
        if(aname.equals("") || aphoneno.equals("")){
            Toast.makeText(MainActivity2.this,"Nothing to Delete !",Toast.LENGTH_SHORT).show();
        }
       else{
            Toast.makeText(MainActivity2.this,"Deleting the contact !",Toast.LENGTH_SHORT).show();
           for(Contact con : contacts){
               if(con.getPhoneNumber().equals(aphoneno)){
                   db.deleteCon(con);
                   break;
               }
           }


        }

    }
}