package com.example.ndpsh.prueba_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private List<String> names;
    private GridView gridview;

    private MyAdapter myAdapter;

    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_grid);

        //Gridview = a un listview pero de varias columnas en vertical , aparte puede utilizar el mismo adaptador
        gridview = (GridView) findViewById(R.id.gridView);

        //Datos a mostrar
        names = new ArrayList<String>();
        names.add("Alex");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Alex");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Alex");
        names.add("Pepe");
        names.add("Dani");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Alex");
        names.add("Pepe");
        names.add("Dani");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Ruben");
        names.add("Pepe");
        names.add("Dani");
        names.add("Alex");


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Cliked: "+names.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        // Enlazamos con nuestro adaptador personalizado
        myAdapter = new MyAdapter(this, R.layout.grid_item, names);
        gridview.setAdapter(myAdapter);

        registerForContextMenu(gridview);
    }
    // Inflamos el layout del menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu, menu);
        return true;

    }
    // Manejamos eventos click en el menu de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item:
                // Añadimos nuevo nombre
                this.names.add("Added n:"+(++counter));
                // Notificamos al adaptador del cambio
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    // Context menu = las opciones del menu ,inflamos el layout del context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
       // Informamos del item que va ser borrado
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.names.get(info.position));

        menuInflater.inflate(R.menu.context_menu, menu);

    }
    // Manejamos eventos click en el context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

       switch (item.getItemId()) {
           case R.id.delete_item:
               // Borramos item clickeado
               this.names.remove(info.position);
               // Notificamos al adaptador del cambio
               this.myAdapter.notifyDataSetChanged();
               return true;
           default:
               return super.onContextItemSelected(item);
       }

    }
}
