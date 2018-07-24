package com.javatechig.droid.ui;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterLsitView extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<ItemListViewCarrossel> item;
    private Context context;

    public AdapterLsitView(Context context, List<ItemListViewCarrossel> item){
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {
            //infla o layout para podermos pegar as views
            mInflater = LayoutInflater.from(context);
            view = mInflater.inflate(R.layout.adapter_carrossel_novo, null);

            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new ItemSuporte();
            itemHolder.txtTitle = ((TextView) view.findViewById(R.id.textview_conta_santander));

            //define os itens na view;
            view.setTag(itemHolder);
        } else {
            //se a view já existe pega os itens.
            itemHolder = (ItemSuporte) view.getTag();
        }

        //pega os dados da lista
        //e define os valores nos itens.
        ItemListViewCarrossel it = item.get(position);
        itemHolder.txtTitle.setText(it.getContaSantander());
        System.out.println("TTTTTTTTTT " + position);

        //retorna a view com as informações
        return view;
    }

    /**
     * Classe de suporte para os itens do layout.
     */
    private class ItemSuporte {
        TextView txtTitle;
    }
}
