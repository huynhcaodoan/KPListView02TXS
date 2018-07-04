package com.cdh.nguyetbong.kp_listview02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    ListView listView;
    ArrayList <String> arrayList;
    ArrayAdapter arrayAdapter;
    String dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonAdd);
        editText = findViewById(R.id.editTextAdd);
        listView = findViewById(R.id.listViewDS);

        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_expandable_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dl = editText.getText().toString();
                arrayList.add(dl);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String tb;
                tb = arrayList.get(i);
                Toast.makeText(MainActivity.this, tb, Toast.LENGTH_SHORT).show();
                arrayAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}
