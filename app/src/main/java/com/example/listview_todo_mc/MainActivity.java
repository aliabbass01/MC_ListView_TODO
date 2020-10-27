package com.example.listview_todo_mc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private EditText input_text;
    private Button button_click_me;
    private ListView my_listView;
    private List<String> myList = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_text = (EditText) findViewById(R.id.input_text);
        button_click_me = (Button) findViewById(R.id.button_click_me);
        my_listView = (ListView) findViewById(R.id.my_listView);

        button_click_me.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AddTextToListView();
            }
        });
    }

    private void AddTextToListView()
    {
        String data = input_text.getText().toString();
        if (data.isEmpty())
        {
            input_text.setError("Enter text to add in list view");
            input_text.requestFocus();
        }
        else
        {
            myList.add(data);
            arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
            my_listView.setAdapter(arrayAdapter);

            input_text.setText("");
        }
    }
}