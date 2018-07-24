package com.javatechig.droid.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaExemplo extends Activity {

    private AdapterLsitView adapterListView;
    private ArrayList<ItemListViewCarrossel> itens;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_exemplo);

        listView = (ListView) findViewById(R.id.listview);
        createListView();

    }

    private void createListView()
    {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListViewCarrossel>();
        ItemListViewCarrossel item1 = new ItemListViewCarrossel("Guilherme Biff");
        ItemListViewCarrossel item2 = new ItemListViewCarrossel("Lucas Volgarini");
        ItemListViewCarrossel item3 = new ItemListViewCarrossel("Eduardo Ricoldi");


        ItemListViewCarrossel item4 = new ItemListViewCarrossel("Guilh");
        ItemListViewCarrossel item5 = new ItemListViewCarrossel("Luc");
        ItemListViewCarrossel item6 = new ItemListViewCarrossel("Edu");
        ItemListViewCarrossel item7 = new ItemListViewCarrossel("Fe");

        ItemListViewCarrossel item8 = new ItemListViewCarrossel("iff");
        ItemListViewCarrossel item9 = new ItemListViewCarrossel("Lucini");
        ItemListViewCarrossel item10 = new ItemListViewCarrossel("Educoldi");
        ItemListViewCarrossel item11 = new ItemListViewCarrossel("Felgo");

        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);

        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
        itens.add(item8);

        itens.add(item9);
        itens.add(item10);
        itens.add(item11);

        //Cria o adapter
        adapterListView = new AdapterLsitView(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }
}
