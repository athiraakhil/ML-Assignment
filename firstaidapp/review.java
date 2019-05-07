package com.example.firstaidapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class review extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2,b3;
   SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        e1 = (EditText) findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        b1 = (Button) findViewById(R.id.add);
        b2 = (Button) findViewById(R.id.view);
        b3 = (Button) findViewById(R.id.del);




        db = openOrCreateDatabase("ReviewDB", Context.MODE_PRIVATE, null);
        if (db != null) {
            Toast.makeText(this, "Created", Toast.LENGTH_SHORT).show();
        }
        db.execSQL("CREATE TABLE IF NOT EXISTS review(name VARCHAR,review VARCHAR);");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (e1.getText().toString().trim().length() == 0 ||
                        e2.getText().toString().trim().length() == 0 ) {
                    showMessage("Error", "Please enter all values");
                    return;
                }

                db.execSQL("INSERT INTO review VALUES('"+e1.getText()+"','"+e2.getText()+"');");

                showMessage("Success", "Record added");
                clearText();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT * FROM review", null);
                if (c.getCount() == 0) {

                    showMessage("Error", "No records found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()) {

                    buffer.append("Name: " + c.getString(0) + "\n");
                    buffer.append("review: " + c.getString(1) + "\n");
                }
                showMessage("Review  Details", buffer.toString());


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().trim().length() == 0){
                    showMessage("Error", "please enter name");
                    return;

                }
                Cursor c = db.rawQuery("SELECT * FROM review WHERE name='"+e1.getText()+"'",null);
                if (c.moveToFirst()) {
                    db.execSQL("DELETE FROM review WHERE name='" + e1.getText() + "'");

                    showMessage("Success", "Record deleted");


                }
                else {
                    showMessage("Success", "invalid name");
                }
                clearText();
            }



        });
    }


    public void showMessage (String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText () {
        e1.setText("");
        e2.setText("");
        e1.requestFocus();


    }
}
