package com.javatechig.droid.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by re033290 on 19/06/2016.
 */
public class AdapterCarrossel extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<ItemListViewCarrossel> itens;

    public AdapterCarrossel(Context context, List<ItemListViewCarrossel> itens){
        this.itens = itens;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemSuporte itemHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_carrossel_novo, null);

            itemHolder = new ItemSuporte();
            itemHolder.textViewContaSantander = ((TextView) convertView.findViewById(R.id.textview_conta_santander));

            convertView.setTag(itemHolder);
        } else {
            itemHolder = (ItemSuporte) convertView.getTag();
        }

        ItemListViewCarrossel item = itens.get(position);
        itemHolder.textViewContaSantander.setText(item.getContaSantander());

        return convertView;
    }

    private class ItemSuporte {
        TextView textViewContaSantander;
    }
}
