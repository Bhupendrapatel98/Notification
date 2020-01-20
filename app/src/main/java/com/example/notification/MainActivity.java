package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.notification.Model.Model;
import com.example.notification.network.Constants;
import com.example.notification.network.PostRequest;
import com.example.notification.network.RetrofitClint;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        //FirebaseInstanceId.getInstance().getToken()

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Model model = new Model();
                model.setTo("cS1-Qg114Oo:APA91bGmQCQ_ZnJpaTJ8QOaIPJbMptNbiho-ed6kLQNcpKJqT3v4hUh3CTOstPHuNjC7LYhxDigy9j3Qv83lbKYL7tfB1Ks_xDoqen8xyliBXx7dXB27hVbw8n3cFPyKn-m-YZepWsbh");

                Model.Data data = new Model.Data();
                data.setTitle("dsghcvsd");
                data.setBody("dcbsj");

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

    }


}
