package com.example.ib.expertlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.maListView);

        final ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Pomme", "Vert"));
        fruits.add(new Fruit("Melon", "Vert"));
        fruits.add(new Fruit("Banane", "Jaune"));
        fruits.add(new Fruit("Citron", "Jaune"));

        CustomAdapter adapter = new CustomAdapter(this, fruits);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,
                        fruits.get(position).getName() + " : " + fruits.get(position).getColor()
                        , Toast.LENGTH_SHORT).show();

            }
        });

    }
}
