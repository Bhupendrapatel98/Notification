package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.notification.Model.Model;
import com.example.notification.Model.ModelMultiple;
import com.example.notification.network.Constants;
import com.example.notification.network.PostRequest;
import com.example.notification.network.RetrofitClint;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btn,btn_multiple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn_multiple = findViewById(R.id.btn_multiple);


        Log.i("djfbkdk", "onCreate: "+FirebaseInstanceId.getInstance().getToken());

        FirebaseMessaging.getInstance().subscribeToTopic("song");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = "fnG9aWp6pJ4:APA91bH85rWZusgqBY3b9iK1_OMu3yc8UK6iEz_CUwKpqJLaQiEuC4dS3c3imi9b6R-BYRUI1PcDB2nS08Wm-OWTwxkUq6O2TvajSGSmOo5zyIguUuhquykDP11aomf97401nYGX3eKq";

                Model model = new Model();
                model.setTo(s);

                Model.Data data = new Model.Data();
                data.setTitle("dsghcvsd");
                data.setBody("dcbsj");

                Log.i("mdzjcxd", "onClick: "+data);

                Model.Notification notification = new Model.Notification();
                notification.setTitle("dsghcvsd");
                notification.setBody("dcbsj");

                model.setData(data);
                model.setNotification(notification);

                RetrofitClint.getRetrofit(Constants.BASE_URL)
                        .create(PostRequest.class)
                        .send(model,"key=AAAAgq-_9IM:APA91bH37M5wjntXz7lGMOv2-h1osmpPeT57j-BlVt3mWV5Ck7zsYhGcUds_v8Ry6zZwH0C5fXxBndnOBjLm0iWaB8MzO7mtxIaxkB9lnPmviJx69xzY7yPnnnrT-spRD45Nm65nnumO")
                        .enqueue(new Callback<JsonObject>() {
                            @Override
                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                                Log.i("sdfnkdsjfd", "onResponse: "+response);
                                Log.i("sdfnkdsjfd", "onResponse: "+response.body());
                            }

                            @Override
                            public void onFailure(Call<JsonObject> call, Throwable t) {

                            }
                        });

            }
        });

        btn_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String s = "song";

                ModelMultiple multiplemodel = new ModelMultiple();
                multiplemodel.setTo("/topics/song");

                Log.i("djfknfjgvfd", "onClick: "+multiplemodel);

                ModelMultiple.Data data = new ModelMultiple.Data();
                data.setTitle("Portugal vs. Denmark");
                data.setBody("great match!");

                Log.i("djfknfjgvfd", "onClick: "+data);

                ModelMultiple.Notification notification = new ModelMultiple.Notification();
                notification.setTitle("Portugal vs. Denmark");
                notification.setBody("great match!");

                Log.i("djfknfjgvfd", "onClick: "+notification);

                multiplemodel.setData(data);
                multiplemodel.setNotification(notification);

                RetrofitClint.getRetrofit(Constants.BASE_URL)
                        .create(PostRequest.class)
                        .song(multiplemodel,"key=AAAAgq-_9IM:APA91bH37M5wjntXz7lGMOv2-h1osmpPeT57j-BlVt3mWV5Ck7zsYhGcUds_v8Ry6zZwH0C5fXxBndnOBjLm0iWaB8MzO7mtxIaxkB9lnPmviJx69xzY7yPnnnrT-spRD45Nm65nnumO")
                        .enqueue(new Callback<JsonObject>() {
                            @Override
                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                                Log.i("mashbccsjddhs", "onResponse: "+response);
                                Log.i("mashbccsjddhs", "onResponse: "+response.body());
                            }

                            @Override
                            public void onFailure(Call<JsonObject> call, Throwable t) {

                            }
                        });
            }
        });

    }


}
