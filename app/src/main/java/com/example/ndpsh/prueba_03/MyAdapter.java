package com.example.ndpsh.prueba_03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public MyAdapter(Context context, int layout, List <String> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.size();
    }
    //va dar el numero de veces que van hacer dibujado los item
    @Override
    public Object getItem(int position) {return this.names.get(position);}
    //Para obtener item de la coleccion
    @Override
    public long getItemId(int id) {
        return id;
    }
    // Es para obtener el elemento de esa coleccion
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // Escoge cada elemento y se dibuja lo que queremos hacer

        // View Holder Pattern = optimizacion del listView , dicho de otro modo preguntamos que datos nuevos ahi y si no esta en el convertView lo añadimos
        ViewHolder holder;

        if (convertView == null){
            // Rellenamos la vista que ha llegado con nuestro layout personalizado.
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout,null);

            holder = new ViewHolder();
            // Llamamos al elemento a modifficar y lo rellenamos
            holder.nameTextView = (TextView) convertView.findViewById(R.id.TextView);
            // Este metodo permite añadir un objecto o un objecto con una id. este segundo caso es para varios
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        // Nos traemos el valor dependiente de la posicion
        String currentName = names.get(position);
        //currentName = (String) getItem(position); -> Otra forma de hacerlo
        holder.nameTextView.setText(currentName);

        // Devolvemos la listView inflada y modificada con nuestros datos
        return convertView;
    }

    static class ViewHolder{
        private TextView nameTextView;
    }
}
