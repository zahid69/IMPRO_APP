package com.itechmandiri.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itechmandiri.myapplication.R;

import java.util.List;

public class NameAdapter extends ArrayAdapter<Name> {

    //storing all the names in the list
    private List<Name> names;

    //context object
    private Context context;

    //constructor
    public NameAdapter(Context context, int resource, List<Name> names) {
        super(context, resource, names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //getting the layoutinflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //getting listview itmes
        View listViewItem = inflater.inflate(R.layout.names, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewName1 = (TextView) listViewItem.findViewById(R.id.textViewName1);
        TextView textViewName2 = (TextView) listViewItem.findViewById(R.id.textViewName2);

        ImageView imageViewStatus = (ImageView) listViewItem.findViewById(R.id.imageViewStatus);

        //getting the current name
        Name id_tasks = names.get(position);
        Name name = names.get(position);
        Name status_tasks = names.get(position);
        Name tanggal_tasks = names.get(position);

        if (name.getStatus() == 0)
        //setting the name to textview
        textViewName.setText(name.getSubject_tasks());
        textViewName1.setText(status_tasks.getStatus_tasks());
        textViewName2.setText(tanggal_tasks.getTanggal_tasks());


        //if the synced status is 0 displaying
        //queued icon
        //else displaying synced icon
        if (name.getStatus() == 0)
            imageViewStatus.setBackgroundResource(R.drawable.stopwatch);
        else
            imageViewStatus.setBackgroundResource(R.drawable.success1);

        return listViewItem;
    }
}
