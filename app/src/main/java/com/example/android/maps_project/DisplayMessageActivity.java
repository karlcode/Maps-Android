package com.example.android.maps_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        ListView m_ListView = (ListView)findViewById(R.id.id_list_view);
        String[] items = new String[] {"Person 1", "Person 2", "Person 3"};
        String[] subitems = new String[] {" 1", " 2", " 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ArrayAdapter<String> subadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, subitems);
        m_ListView.setAdapter(adapter);
        m_ListView.setAdapter(subadapter);
        m_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DisplayMessageActivity.this, "Toast " + l, Toast.LENGTH_LONG).show();
            }
        });
        Button gitClick = (Button) findViewById(R.id.gitButton);
        gitClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(DisplayMessageActivity.this).create(); //Read Update
                alertDialog.setTitle("hi");
                alertDialog.setMessage("this is my app");


                alertDialog.show();  //<-- See This!
                Toast.makeText(DisplayMessageActivity.this, "Hi there", Toast.LENGTH_SHORT).show();
            }
        });
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MapsActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }
}
