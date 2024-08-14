package com.example.quotify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class MainActivity3 extends AppCompatActivity {

    Button generate;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        generate=findViewById(R.id.button3);
        editText=findViewById(R.id.editTextNumber);


        generate.setOnClickListener(new View.OnClickListener() {
//            int num;
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity3.this, MainActivity4.class);
//                if(editText.length()>0){
//                     num= Integer.parseInt(editText.getText().toString());
//                }
                intent.putExtra("num",10);
                startActivity(intent);
            }
        });

    }
}