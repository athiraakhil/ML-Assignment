package com.example.firstaidapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;




import java.util.ArrayList;


class Singlerow
{
    String title;
    String description;
    int image;

    Singlerow(String title,String description,int image)
    {
        this.title=title;
        this.description=description;
        this.image=image;


    }

}

class myadapter extends BaseAdapter{

    ArrayList<Singlerow>list;
    Context context;
    public myadapter(Context c){
        this.context=c;
        list=new ArrayList<Singlerow>();
        String titles[]={"Burns","Heart Attack","Asthma","Chocking","Bleeding","Allergies","Snakebites","Drown","Shock","Heat","Fever","Fracture"};
        String description[]={"","","","","","","","","","","","",""};
        int image[]={R.drawable.b,R.drawable.h,R.drawable.a,R.drawable.ch,R.drawable.ble,R.drawable.all,R.drawable.snk,R.drawable.dro,R.drawable.sho,R.drawable.he,R.drawable.fev,R.drawable.fra};
        for(int i=0; i<=11;i++){
            Singlerow s=new Singlerow(titles[i],description[i],image[i]);
            list.add(s);



        }

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =(LayoutInflater)context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.layout,parent,false);
        TextView title=(TextView)row.findViewById(R.id.textView3);
        TextView description=(TextView)row.findViewById(R.id.textView4);
        ImageView image=(ImageView)row.findViewById(R.id.imageView);
        Singlerow singlerow =list.get(position);
        title.setText(singlerow.title);
        description.setText(singlerow.description);
        image.setImageResource(singlerow.image);
        return row;




    }
}
public class MainActivity extends AppCompatActivity {
    ListView lv;

    String titles[]={"BURNS","Heart Attack","Asthma","Chocking","Bleeding","Allergies","Snakebites","Drown","Shock","Heat","Fever","Fracture"};

    String description[]={" " +
            "\n" +
            "" +
            " \n 1. Stop Burning Immediately\n" +
            "\n" +
            "Put out fire or stop the person's contact with hot liquid, steam, or other material.\n" +
            "Help the person \"stop, drop, and roll\" to smother flames.\n" +
            "Remove smoldering material from the person.\n" +
            "Remove hot or burned clothing. If clothing sticks to skin, cut or tear around it.\n" +
            "2. Remove Constrictive Clothing Immediately\n" +
            "\n" +
            "Take off jewelry, belts, and tight clothing. Burns can swell quickly.\n",

            "" +
                    "" +
                    "" +
                    "\n " +
                    "\n" +
                    " 1. Call 911 or your local emergency number. Don't ignore or attempt to tough out the symptoms of a heart attack. If you don't have access to emergency medical services, have a neighbor or a friend drive you to the nearest hospital.\n" +
            "\n" +
            "\n 2.Drive yourself only as a last resort, and realize that it places you and others at risk when you drive under these circumstances.\n" +
            "\n" +
            "\n 3.If you haven't received CPR training, doctors recommend performing only chest compressions (about 100 to 120 compressions a minute)." +
            "\n"
            ,"" +
            " \n \n" +
            "\n 1.Call emergency assistance immediately. Dial Triple Zero (000):\n" +
            "\n 2. Sit the person upright\n" +
            "\n 3.Give 4 separate puffs of blue/grey reliever puffer\n" +
            "– Shake puffer\n" +
            "– Put 1 puff into spacer\n" +
            "– Take 4 breaths from spacer\n" +
            "OR give 1 more dose of Bricanyl or Symbicort inhaler\n" +
            "If there is still no improvement dial\n" +
            "Keep giving 4 separate puffs every 4 minutes\n" +
            "until emergency assistance arrives "," \n \n \n 1.Stand behind the person. Place one foot slightly in front of the other for balance. Wrap your arms around the waist. Tip the person forward slightly. If a child is choking, kneel down behind the child.\n" +
            "\n 2.Make a fist with one hand. Position it slightly above the person's navel.\n" +
            "\n 3.Grasp the fist with the other hand. Press hard into the abdomen with a quick, upward thrust.\n" +
            "\n 4.Perform between six and 10 abdominal thrusts until the blockage is dislodged.\n","\n \n 1.Rinse the cut or wound with water and apply pressure with sterile gauze, a bandage, or a clean cloth." +
            "\n \n" +
            "\n  2.If blood soaks through the bandage, place another bandage on top of the first and keep applying pressure." +
            "\n \n3.Raise the injured body part to slow bleeding." +
            "\n \n 4.When bleeding stops, cover the wound with a new, clean bandage.","\n \n \n 1.Stay with the patient and ensure total rest" +
            " \n \n 2.Give any prescribed medication or treatment " +
            "\n \n 3.If the reaction follows exposure to a chemical   " +
            "\n \n 4.Observe the patient closelY","\n \n \n 1.Remain calm and move beyond the snake's striking distance.\n" +
            "  2.  Remove jewelry and tight clothing before you start to swell.\n" +
            "   3. Position yourself, if possible, so that the bite is at or below the level of your heart.\n" +
            "  4.  Clean the wound, but don't flush it with water. Cover it with a clean, dry dressing.\n" +
            "\n","1. Get Help\n" +
            "\n" +
            "    Notify a lifeguard, if one is close. If not, ask someone to call 911.\n" +
            "\n" +
            "    If you are alone, follow the steps below.\n" +
            "\n" +
            "2. Move the Person\n" +
            "\n" +
            "    Take the person out of the water.\n" +
            "\n" +
            "3. Check for Breathing\n" +
            "\n" +
            "    Place your ear next to the person's mouth and nose. Do you feel air on your cheek?\n" +
            "\n" +
            "    Look to see if the person's chest is moving.\n" +
            "\n" +
            "4. If the Person is Not Breathing, Check Pulse\n" +
            "\n" +
            "    Check the person's pulse for 10 seconds.\n" +
            "\n" +
            "5. If There is No Pulse, Start CPR\n"," \n \n \n 1.Have the person lie down on his or her back with feet higher than the head. If raising the legs will cause pain or further injury, keep him or her flat. Keep the person still.\n" +
            "    \n 2.Check for signs of circulation . If absent, begin CPR.\n" +
            "   \n 3. Keep the person warm and comfortable. Even if the person complains of thirst, give nothing by mouth.\n" +
            "   \n 4. If the person vomits or bleeds from the mouth, turn the person on his or her side to prevent choking.\n"," \n \n  \n 1. Call 911 \n " +
            "Heat stroke is a medical emergency. Seek immediate emergency care if you think someone might have heat stroke. \n" +
            " \n  2. Lower Body Temperature While Waiting for Emergency Services to Arrive." +
            " \n \n  3. Treat Symptoms" +
            "If the person experiences seizures, keep him or her safe from injury." +
            "\n  \n 4.If the person vomits, turn the person on his or her side to keep the airway open.","\n" +
            "   \n \n 1. Drink plenty of fluids to stay hydrated.\n" +
            "   \n 2. Dress in lightweight clothing.\n" +
            "   \n 3. Use a light blanket if you feel chilled, until the chills end.\n" +
            "   \n 4. Take acetaminophen (Tylenol, others) or ibuprofen (Advil, Motrin IB, others)"," \n \n 1.Stop any bleeding: If they âre bleeding, elevate and apply pressure to the wound using a sterile bandage, a clean cloth, or a clean piece of clothing.\n" +
            "   \n 2. Wrap an ice pack or bag of ice cubes in a piece of cloth and apply it to the injured area for up to 10 minutes at a time.\n" +
            "    \n 3.Treat them for shock: Help them get into a comfortable position, encourage them to rest, and reassure them. Cover them with a blanket or clothing to keep them warm.\n"};

    int image[]={R.drawable.b,R.drawable.h,R.drawable.a,R.drawable.ch,R.drawable.ble,R.drawable.all,R.drawable.snk,R.drawable.dro,R.drawable.sho,R.drawable.he,R.drawable.fev,R.drawable.fra};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.list1);
        lv.setAdapter(new myadapter(this));


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View arg1,
                                    int position, long arg3) {

                Intent in = new Intent(MainActivity.this, description.class);

                String s=titles[position].toString();
                String r=description[position].toString();

                in.putExtra("name",s);
                in.putExtra("img",image[position]);
                in.putExtra("des",r);


                startActivity(in);

            }
        });
    }
}