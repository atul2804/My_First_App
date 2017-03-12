package com.example.atul.basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizUp extends AppCompatActivity {

    Button skip,next;
    TextView question,num;
    RadioGroup group;
    RadioButton btnA,btnB,btnC,btnD,answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_up);

        skip = (Button) findViewById(R.id.skip);
        next = (Button) findViewById(R.id.submit);
        question = (TextView) findViewById(R.id.question);
        num = (TextView) findViewById(R.id.num);

        group= (RadioGroup) findViewById(R.id.rggroup);
        btnA = (RadioButton) findViewById(R.id.buttona);
        btnB = (RadioButton) findViewById(R.id.buttonb);
        btnC = (RadioButton) findViewById(R.id.buttonc);
        btnD = (RadioButton) findViewById(R.id.buttond);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedID = group.getCheckedRadioButtonId();

                answer = (RadioButton) findViewById(selectedID);

                Toast.makeText(getApplicationContext(),answer.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
