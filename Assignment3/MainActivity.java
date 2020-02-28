package com.example.notetaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnLoad, btnSave, btnSearch;

    EditText txtID, txtContent, txtTitle, txtTag;

    TagMapModel map = new TagMapModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtID = findViewById(R.id.txtID);
        txtTitle = findViewById(R.id.txtTitle);
        txtTag = findViewById(R.id.txtTag);
        txtContent = findViewById(R.id.txtContent);


        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getPreferences(0);

                String json = pref.getString("tagmap", "");
                if (json.length() == 0) {
                    txtTag.setText("Tag not exists!");
                    return;
                }

                map = TagMapModel.fromJson(json);
                Log.i("map.json", json);

                String tag = txtTag.getText().toString();
                List<String> list = map.get(tag);

                if (list == null) {
                    txtTag.setText("Tag not exists!");
                    return;
                }

                NoteModel note = new NoteModel();
                note.id = list.get(0);
                json = pref.getString(note.id, "");

                if (json.length() == 0) {
                    txtTitle.setText("ID not found. New node is created!");
                } else {

                    note = NoteModel.fromJson(json);
                    txtContent.setText(note.content);
                    txtTitle.setText(note.title);
                    txtTag.setText(note.tag);
                    txtID.setText(note.id);
                }
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteModel note = new NoteModel();
                note.id = txtID.getText().toString();
                note.title = txtTitle.getText().toString();
                note.content = txtContent.getText().toString();
                note.tag = txtTag.getText().toString();

                map.add(note.tag, note.id ); // update tags!

                SharedPreferences pref = getPreferences(0);
                SharedPreferences.Editor editor = pref.edit();

                String json = note.toJson();
                Log.i("note.json", json);

                editor.putString(note.id, json);

                json = map.toJson();
                Log.i("map.json", json);
                editor.putString("tagmap", json);

                editor.commit();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txtID.getText().toString();
                SharedPreferences pref = getPreferences(0);

                String json = pref.getString(id, "");

                if (json.length() == 0) {
                    txtTitle.setText("ID not found. New node is created!");
                } else {
                    NoteModel note = NoteModel.fromJson(json);
                    txtContent.setText(note.content);
                    txtTitle.setText(note.title);
                    txtTag.setText(note.tag);
                    txtID.setText(note.id);
                }

            }
        });

    }
}
