package com.example.quotify;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity2 extends AppCompatActivity {
    interface Singlequote{
        @GET("/random")
        Call<model>getdata();
    }
    TextView textView1;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView1=findViewById(R.id.textView2);
        textView2=findViewById(R.id.textView3);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.quotable.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Singlequote singlequote= retrofit.create(Singlequote.class);
        singlequote.getdata().enqueue(new Callback<model>() {
            @Override
            public void onResponse(@NonNull Call<model> call, @NonNull Response<model> response) {
                assert response.body() != null;
                textView1.setText(response.body().content);
                textView2.setText(response.body().author);
            }

            @Override
            public void onFailure(@NonNull Call<model> call, @NonNull Throwable throwable) {
                   textView1.setText(throwable.getMessage());
            }
        });
    }
}