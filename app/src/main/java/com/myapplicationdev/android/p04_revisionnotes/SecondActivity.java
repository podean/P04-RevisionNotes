package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

	ListView lvNotes;
	ArrayList<Note> notes;
	ArrayAdapter aaNotes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView

        setContentView(R.layout.activity_second);

		lvNotes = (ListView)findViewById(R.id.lv);
		final DBHelper db = new DBHelper(SecondActivity.this);

		notes = db.getAllNotes();
        aaNotes = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, notes);
        lvNotes.setAdapter(aaNotes);

        db.close();

	}


}
