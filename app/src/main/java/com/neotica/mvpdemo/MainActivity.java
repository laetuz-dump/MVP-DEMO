package com.neotica.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neotica.mvpdemo.Model;

public class MainActivity extends AppCompatActivity implements AppView{

    //Implementing MVP pattern
    Button button;
    TextView textView;

    //Linking activity with presenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        //instantiating the presenter
        presenter = new Presenter(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling the presenter data from Model
                //No linkage between Activity and Model
                //MainActivity is handling UI only
                //All logic occurs at the presenter
                presenter.GetAppDetail();
            }
        });
    }
    
    @Override
    public void onGetAppName(String string) {
        textView.setText(string);
    }

    //view: Activity with Text & Button
    //Model: Model.java class
    //Presenter: Presenter.java
}