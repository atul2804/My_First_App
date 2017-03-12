package com.example.atul.basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText edit_name,edit_surname,edit_marks;
    Button b4;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myDb = new DatabaseHelper(this);
        edit_name = (EditText) findViewById(R.id.editText_name);
        edit_surname = (EditText) findViewById(R.id.editText_surname);
        edit_marks = (EditText) findViewById(R.id.editText_marks);
        b4 = (Button) findViewById(R.id.button);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isInserted =  myDb.insertData(edit_name.getText().toString(),edit_surname.getText().toString(),edit_marks.getText().toString());
                if(isInserted == 1)
                    Toast.makeText(Main2Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Main2Activity.this,"Unsuccessful",Toast.LENGTH_LONG).show();
            }
        });
    }
}
