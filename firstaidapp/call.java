package com.example.firstaidapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class call extends AppCompatActivity {

    TextView t1,t2,t3;
    Button bt,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        //t1=(TextView)findViewById(R.id.t1);
        //t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t5);
        bt=(Button)findViewById(R.id.b2);
        b2=(Button)findViewById(R.id.re);
        Intent i3=getIntent();
        //String name=i3.getStringExtra("nam");
        //String qua=i3.getStringExtra("quan");
        String phn=i3.getStringExtra("phone");

        //t1.setText(name);
       // t2.setText(qua);
        t3.setText(phn);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p=t3.getText().toString();

                Intent ph=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+p));
                startActivity(ph);


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(call.this,review.class);

                startActivity(i);
            }
        });
    }
}
