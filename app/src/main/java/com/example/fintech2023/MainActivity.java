package com.example.fintech2023;

import static com.example.fintech2023.utils.TextCounter.getCharsCount;
import static com.example.fintech2023.utils.TextCounter.getWordsCount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spCountingOptions;
    private EditText edMain;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvResult = findViewById(R.id.tvResult);
        this.edMain = findViewById(R.id.edMain);
        this.spCountingOptions = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        this.spCountingOptions.setAdapter(adapter);
    }

    public void btnCountOnClick(View view) {
        String userInput = this.edMain.getText().toString();
        String selectedOption = this.spCountingOptions.getSelectedItem().toString();
        if(userInput.matches("")){
            Toast.makeText(this, "Input is empty!", Toast.LENGTH_LONG).show();
            this.tvResult.setText("0");
            return;
        }
        if (selectedOption.equalsIgnoreCase(getResources().getString(R.string.chars_selection))) {
            this.tvResult.setText(getCharsCount(userInput));
        }
        else {
            this.tvResult.setText(getWordsCount(userInput));
        }
    }

}