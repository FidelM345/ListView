package com.example.fidelmomolo.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Fidel M Omolo on 11/25/2017.
 */

class CustomAdapter extends ArrayAdapter<String>{

//private final Activity context;
private final String[]description;
private final String[]food;
private final Integer[]imgid;




    public CustomAdapter(@NonNull Context context, String[]food1, String[] description1, Integer[] imgid1) {
        super(context,R.layout.list_me, food1);


       // this.context= (Activity) context;
        this.food=food1;
        this.description = description1;
        this.imgid=imgid1;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //the code represents a single row on the list view widget
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View customView=layoutInflater.inflate(R.layout.list_me,parent,false);


        //code for getting each single text item on the list
       // String getfooditem=getItem(position);

        TextView textView1=(TextView)customView.findViewById(R.id.text125);
        TextView textView=(TextView)customView.findViewById(R.id.text1);
        ImageView imageView34=(ImageView)customView.findViewById(R.id.image65);

        textView.setText(food[position]);

        textView1.setText(description[position]);

        imageView34.setImageResource(imgid[position]);


        return customView;


    }

}
