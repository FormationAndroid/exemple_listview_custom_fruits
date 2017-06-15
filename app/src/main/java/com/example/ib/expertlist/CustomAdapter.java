package com.example.ib.expertlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends ArrayAdapter<Fruit> {

    private class ViewHolder {
        TextView txtName;
        TextView txtColor;

        public ViewHolder(View view) {
            txtName = (TextView) view.findViewById(R.id.textView_fruit_name);
            txtColor = (TextView) view.findViewById(R.id.textView_fruit_color);
        }
    }

    CustomAdapter(Context context, ArrayList<Fruit> data) {
        super(context, R.layout.item_fruit, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_fruit, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag(); // permet de récupérer le tag du holder pour optimiser les ressources (pas besoin d'inflater à nouveau)


        final Fruit fruit = getItem(position);

        if (fruit != null) {
            holder.txtName.setText(fruit.getName());
            holder.txtColor.setText(fruit.getColor());
        }

        return convertView;
    }
}
