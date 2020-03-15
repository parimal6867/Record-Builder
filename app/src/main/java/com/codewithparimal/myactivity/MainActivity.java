package com.codewithparimal.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void clickFunc(View view)
    {
        openActivity2();
    }
    public void openActivity2()
    {
        Intent intent =new Intent(this,Activity2.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void startdbapp(View view)
    {
        new dbManager(this);
        startActivity(new Intent(this,Activity3.class));
    }
}
