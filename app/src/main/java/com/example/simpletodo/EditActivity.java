package com.example.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        saveButton = findViewById(R.id.saveButton);

        getSupportActionBar().setTitle("Edit Item");

        //Prefill text of item
        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        //Click listener for save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //create an intent that contains results
                Intent intent = new Intent();
              //Pass the results of edits
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
              //set results of the intent
                setResult(RESULT_OK, intent);
              //Close screen and return
              finish();
            }
        });
    }
}