package com.example.ndpsh.prueba_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private ListView listView;
   private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        //Datos a mostrar
        names = new ArrayList<String>();
        names.add("Alex");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");

        // Adaptador la forma visual del ListView,primero se le pasa el contexto = activity en el que nos encontramos
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);

        // Enlazamos nuestro listview junto adaptador
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Cliked: "+names.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
