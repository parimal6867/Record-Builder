package com.codewithparimal.myactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText editTextPurpose;
    EditText editTextName;
    EditText editTextAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        editTextPurpose=(EditText)findViewById(R.id.editText2);
        editTextName=(EditText)findViewById(R.id.editText6);
        //EditText editTextPurpose=findViewById(R.id.editText2);
        editTextAmount=(EditText)findViewById(R.id.editText5);

    }
    int i=0;
    public void Click(View v)
    {
        i=1;
    }

    String S;

    public void saveButton(View view)
    {
        if(i==1)
        {
            S="Give to "+editTextName+" Rs. "+editTextAmount;
        }
        else
        {
            S="Take from "+editTextName+" Rs. "+editTextAmount;
        }

        //Toast.makeText(this, "Save Successfull", Toast.LENGTH_LONG).show();

        dbManager db =new dbManager(this);
        String res=db.addRecord( editTextName.getText().toString(),editTextAmount.getText().toString(),editTextPurpose.getText().toString());

        Toast.makeText(this, res, Toast.LENGTH_LONG).show();
        editTextName.setText("");
        editTextAmount.setText("");
        editTextPurpose.setText("");
    }


}
