package com.example.firstaidapp;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstaidapp.R;

public class description extends AppCompatActivity {
    TextView details1,name;
    ImageView img1;
    Button b,b2;
    //String na[]={"Dr.Anoop P","Dr.Elizabeth","Dr.Manu M","Dr.Asha Alex","Dr.Sruthi S Kumar","Dr.Haritha V"};
   // String qa[]={"MBBS,MD","MBBS,FRCS","MBBS MS","MBBS MD","MBBS MS"};
    String phn[]={"Emegency no:911","111","000","911","666","911"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        name=(TextView)findViewById(R.id.name);
        img1=(ImageView)findViewById(R.id.img1);

        details1=(TextView)findViewById(R.id.des);
        b=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.ad);

        Intent i2=getIntent();
        String name2=i2.getStringExtra("name");
        String des1=i2.getStringExtra("des");
        Integer img=i2.getIntExtra("img",0);



        name.setText(name2);
        img1.setImageResource(img  );
        details1.setText(des1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(description.this,call.class);
                int pos1=i3.getIntExtra("pos",0);
                //String nam=na[pos1].toString();
                //String q1=qa[pos1].toString();
                String ph2=phn[pos1].toString();
               i3.putExtra("pos1",pos1);
                //i3.putExtra("nam",nam);
                //i3.putExtra("quan",q1);
                i3.putExtra("phone",ph2);
                startActivity(i3);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(description.this,tip.class);
                startActivity(in);
            }
        });

    }
}


