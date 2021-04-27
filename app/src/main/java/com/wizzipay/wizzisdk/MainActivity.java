package com.wizzipay.wizzisdk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.plaid.link.Plaid;
import com.wizzipay.wizzipay.Dashboard;


import com.wizzipay.wizzipay.Utils.Sharedpreference;



import java.net.URI;

import retrofit2.http.Url;


public class MainActivity extends AppCompatActivity {

    AppCompatButton wallet_full_screen_button,wallet_mini_screen_button;
    AppCompatImageButton       payment_full_screen_button_telegram,payment_full_screen_button_messanger,payment_full_screen_button_chrome,payment_full_screen_button_whatsup,
                        payment_mini_screen_button_telegram,payment_mini_screen_button_messanger,payment_mini_screen_button_chrome,payment_mini_screen_button_whatsup;
    AppCompatButton transactions_full_screen_button,transactions_mini_screen_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Plaid.initialize(getApplication());

        wallet_full_screen_button = findViewById(R.id.wallet_full_screen_button);
        wallet_mini_screen_button = findViewById(R.id.wallet_mini_screen_button);
        payment_full_screen_button_telegram = findViewById(R.id.payment_full_screen_button_telegram);
        payment_full_screen_button_messanger = findViewById(R.id.payment_full_screen_button_messanger);
        payment_full_screen_button_chrome = findViewById(R.id.payment_full_screen_button_chrome);
        payment_full_screen_button_whatsup = findViewById(R.id.payment_full_screen_button_whatsup);
        payment_mini_screen_button_telegram = findViewById(R.id.payment_mini_screen_button_telegram);
        payment_mini_screen_button_messanger = findViewById(R.id.payment_mini_screen_button_messanger);
        payment_mini_screen_button_chrome = findViewById(R.id.payment_mini_screen_button_chrome);
        payment_mini_screen_button_whatsup = findViewById(R.id.payment_mini_screen_button_whatsup);
        transactions_full_screen_button = findViewById(R.id.transactions_full_screen_button);
        transactions_mini_screen_button = findViewById(R.id.transactions_mini_screen_button);


        Intent intent_deep = getIntent();
         String appid ="";

        Dashboard.handle_intent(getApplicationContext(),intent_deep,0.8,Gravity.BOTTOM);



        payment_full_screen_button_whatsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("class_name","payment");
                intent.putExtra("appid","com.whatsapp");
                startActivity(intent);
            }
        });

        wallet_full_screen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("class_name","wallet");
              //  intent.putExtra("appid","com.whatsapp");
                startActivity(intent);
            }
        });

        payment_full_screen_button_telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("class_name","payment");
                intent.putExtra("appid","org.telegram.messenger");
                startActivity(intent);

            }
        });
        payment_full_screen_button_messanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("class_name","payment");
                //intent.putExtra("appid","com.facebook.orca");
                intent.putExtra("appid","com.google.android.gm");
                startActivity(intent);

            }
        });
        payment_full_screen_button_chrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("class_name","payment");
                intent.putExtra("appid","com.android.chrome");
                startActivity(intent);

            }
        });
        transactions_full_screen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("class_name","transactions");
                intent.putExtra("appid","com.whatsapp");
                startActivity(intent);
            }
        });
        wallet_mini_screen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = Sharedpreference.getPreferenceValue(MainActivity.this,"token","");

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("class_name","wallet");
                intent.putExtra("height",.8);
                intent.putExtra("gravity", Gravity.BOTTOM);
                startActivity(intent);
                //finish();
            }
        });
        payment_mini_screen_button_whatsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("height",.8);
                intent.putExtra("class_name","payment");
                intent.putExtra("appid","com.whatsapp");
                intent.putExtra("gravity", Gravity.BOTTOM);
                startActivity(intent);

            }
        });


        payment_mini_screen_button_telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("height",.8);
                intent.putExtra("class_name","payment");
                intent.putExtra("appid","org.telegram.messenger");
                intent.putExtra("gravity", Gravity.BOTTOM);
                startActivity(intent);

            }
        });
        payment_mini_screen_button_messanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("height",.8);
                intent.putExtra("class_name","payment");
               // intent.putExtra("appid","com.facebook.orca");
                intent.putExtra("appid","com.google.android.gm");
                intent.putExtra("gravity", Gravity.BOTTOM);
                startActivity(intent);

            }
        });
        payment_mini_screen_button_chrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("height",.8);
                intent.putExtra("class_name","payment");
                intent.putExtra("appid","com.android.chrome");
                intent.putExtra("gravity", Gravity.BOTTOM);
                startActivity(intent);

            }
        });

        transactions_mini_screen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("height",.8);
                intent.putExtra("class_name","transactions");
                intent.putExtra("gravity", Gravity.BOTTOM);
                startActivity(intent);
            }
        });
    }
}
