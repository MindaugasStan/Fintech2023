package com.example.fintech2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DeleteNoteActivity extends AppCompatActivity {

    private  Spinner spNotes;
    private ArrayAdapter listAdapter;
    private ArrayList<String> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        this.spNotes = findViewById(R.id.spNotes);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.notesList = new ArrayList<>(sp.getStringSet("note", new HashSet<>()));
        this.listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, notesList);
        this.spNotes.setAdapter(this.listAdapter);
    }

    public void btnDeleteClick(View view) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor spEd = sp.edit();
        Set<String> oldSet = sp.getStringSet("note", new HashSet<>());
        oldSet.remove(this.spNotes.getSelectedItem());

        spEd.putStringSet("note", oldSet);
        spEd.apply();
        finish();
    }
}