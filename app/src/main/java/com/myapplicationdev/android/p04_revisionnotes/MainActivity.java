package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    RadioGroup rgStars;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = (EditText)findViewById(R.id.editTextNote);
        rgStars = (RadioGroup)findViewById(R.id.radioGroupStars);
        btnInsert = (Button)findViewById(R.id.buttonInsertNote);
        btnShowList = (Button)findViewById(R.id.buttonShowList);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rgStars.getCheckedRadioButtonId();
                final RadioButton rbStars = (RadioButton)findViewById(selectedButtonId);

                DBHelper db = new DBHelper(MainActivity.this);
                db.insertNote(etNote.getText().toString(),Integer.parseInt(rbStars.getText().toString()));
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

                db.close();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),SecondActivity.class);
                startActivity(i);
            }
        });


    }
}
