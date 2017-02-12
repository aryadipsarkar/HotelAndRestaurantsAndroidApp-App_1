package com.example.arya.project3_a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastSender extends AppCompatActivity implements View.OnClickListener {
    Button hotel_button;
    Button restaurant_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_sender_layout);
        //Registering for the two buttons
        hotel_button= (Button) findViewById(R.id.broadcast_hotel);
        restaurant_button= (Button) findViewById(R.id.broadcast_restaurant);
        //OnClickListener() for the Buttons
        hotel_button.setOnClickListener(this);
        restaurant_button.setOnClickListener(this);
    }

    //Registering for the Broadcast Intents on the button clicks
    @Override
    public void onClick(View view) {
        //If Hotel button is pressed
        if (view.getId()==R.id.broadcast_hotel){
            //Register the intent
            Intent intent=new Intent();
            //Give the name of the intent to be broad-casted
            intent.setAction("com.example.arya.project3_a1");
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            //Add information about which Button is clicked
            intent.putExtra("message","Hotel");
            //Register for the BroadCast
            sendOrderedBroadcast(intent, null);
        }
        //If Restaurant button is pressed
        if (view.getId()==R.id.broadcast_restaurant){
            //Register the intent
            Intent intent=new Intent();
            //Give the name of the intent to be broad-casted
            intent.setAction("com.example.arya.project3_a1");
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            //Add information about which Button is clicked
            intent.putExtra("message","Restaurant");
            //Register for the BroadCast
            sendOrderedBroadcast(intent, null);
        }
    }
}
