package com.wizzipay.wizzisdk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.JsonElement;
import com.plaid.link.Plaid;
import com.wizzipay.wizzipay.Dashboard;


import com.wizzipay.wizzipay.Login;
import com.wizzipay.wizzipay.Model.ModelLog;
import com.wizzipay.wizzipay.Signup;
import com.wizzipay.wizzipay.Utils.APIService;
import com.wizzipay.wizzipay.Utils.ApiUtils;
import com.wizzipay.wizzipay.Utils.Sharedpreference;



import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
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

          Login.login_testing(MainActivity.this,"9876543210","Pass@123","+91");

       // Signup.signup_testing(MainActivity.this,"8015044019","+91","singh","singh","mail.gmail.com","iiii");


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
                final Map<String, String> log_map = new HashMap<>();
                log_map.put("classname", "wallet");
                log_map.put("appid", "com.whatsapp");
                String endurl = "wallet";
                String log_string = log_map.toString();
                call_logs( MainActivity.this,endurl, log_string, log_string);


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

    public void call_logs(Activity activity,String appEndpointURL, String appRequestJSON, String appResponseJSON) {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        String date = df.format(Calendar.getInstance().getTime());
        ModelLog model_log = new ModelLog("mobile", "Testharness", "Android", "", "1.0.1", date, appEndpointURL, appRequestJSON, appResponseJSON);
        System.out.println("logger-----------------" + model_log.toString());
        APIService mAPIService ;
        mAPIService = ApiUtils.apiService(activity);

        mAPIService.logs(model_log).enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, retrofit2.Response<JsonElement> response) {
                System.out.println("logger-----------------" + response.toString());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                System.out.println("logger-----------------" + t.toString());
            }
        });
    }
}
