package com.example.tictac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

public class Main22Activity extends AppCompatActivity {

    EditText etName, et1Name;
    Button bDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        etName = (EditText) findViewById(R.id.etName);
        et1Name = (EditText) findViewById(R.id.et1Name);
        bDone = (Button) findViewById(R.id.bDone);

        bDone.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View view) {

                                         String name1 = etName.getText().toString();
                                         String name2 = et1Name.getText().toString();
                                         Intent i = new Intent(Main22Activity.this, MainActivity.class);
                                         i.putExtra("NAME1", name1);
                                         i.putExtra("NAME2", name2);
                                         startActivity(i);
                                     }
                                 }
        );
    }
}