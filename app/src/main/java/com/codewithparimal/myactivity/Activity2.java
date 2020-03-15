package com.codewithparimal.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    dbManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

    }
    public void clickFun(View view)
    {
        Intent intent1 =new Intent(this,Activity3.class);
        startActivity(intent1);
    }
    public void ClickRecords(View a)
    {
        /*Activity3 ac=new Activity3();
        TextView textView=findViewById(R.id.textView4);
        textView.setText(ac.S);*/
        Intent intent2 =new Intent(this,Records.class);
        startActivity(intent2);
        db=new dbManager(this);
        Cursor cursor=db.alldata();
        if(cursor.getCount()==0)
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        else {
            while (cursor.moveToNext()) {
                Toast.makeText(this, "" + cursor.getString(0) + " will give you " + cursor.getString(1), Toast.LENGTH_LONG).show();
            }
        }
    }
}
