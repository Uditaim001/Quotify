package com.example.quotify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class MainActivity4 extends AppCompatActivity {
    interface MultipleQuotes{
        @GET("/quotes/random")
        Call<List<model>> getmdata(@Query("limit") int num);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent intent = getIntent();
        int num = intent.getIntExtra("num", 2);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.quotable.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ListView listView = findViewById(R.id.listview);
        MultipleQuotes multipleQuotes = retrofit.create(MultipleQuotes.class);
        multipleQuotes.getmdata(num).enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> data = response.body();
                List<String> quotesList = new ArrayList<>();

                for (int i = 0; i < num; i++) {
                    String quote = data.get(i).content;
                    String author = data.get(i).author;
                    quotesList.add(quote + "\n— " + author);
                }



                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                        MainActivity4.this,
                        android.R.layout.simple_list_item_1,
                        quotesList
                );

                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable throwable) {
                // Handle failure
                Toast.makeText(MainActivity4.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
