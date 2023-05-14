package com.example.fintech2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
    }
    public void onAddNoteClick(View view) {
        EditText txtNote = findViewById(R.id.txtNote);
        if (txtNote.getText().toString().matches("")) {
            Toast.makeText(this, "Input is empty!", Toast.LENGTH_LONG).show();
        }
        else {
            //https://stackoverflow.com/questions/14034803/misbehavior-when-trying-to-store-a-string-set-using-sharedpreferences
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor spEd = sp.edit();
            Set<String> oldSet = sp.getStringSet("note", new HashSet<>());
            Set<String> newStrSet = new HashSet<>();
            newStrSet.add(txtNote.getText().toString());
            newStrSet.addAll(oldSet);

            spEd.putStringSet("note", newStrSet);
            spEd.apply();

            finish();
        }
    }
}