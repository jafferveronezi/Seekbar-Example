package com.javatechig.droid.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CarrosselNovo extends Activity {

    ListView listViewCarrossel;
    View viewAdapterCarrossel;
    TextView textview_conta_santander;

    PopupWindow popupWindow;
    View popupView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrossel_novo);

        final LinearLayout list1 = (LinearLayout) this.findViewById(R.id.teste);
        list1.removeAllViews();


        LayoutInflater inflater = this.getLayoutInflater();
        View view = null;
        TextView titulo = null;

        view = inflater.inflate(R.layout.adapter_carrossel_novo, null);
        titulo = (TextView) view.findViewById(R.id.textview_conta_santander);

        titulo.setText("teste");

        list1.addView(view);


        listViewCarrossel = (ListView) findViewById(R.id.listview_carrossel);
        listViewCarrossel.setVisibility(View.GONE);
//        createListView();
//
//        listViewCarrossel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(CarrosselNovo.this, "Item clicado", Toast.LENGTH_SHORT).show();
//            }
//        });


// popup ------------

        list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                popupView = layoutInflater.inflate(R.layout.adapter_carrossel_novo, null);
                popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                RelativeLayout relativeLayout = (RelativeLayout) popupView.findViewById(R.id.relativelayout_carrosselNovo);
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

                popupWindow.showAsDropDown(list1, 0, 0);
            }
        });

    }

    private void createListView()
    {
       ArrayList itens = new ArrayList<ItemListViewCarrossel>();
        ItemListViewCarrossel item1 = new ItemListViewCarrossel("Guilherme Biff");
        ItemListViewCarrossel item2 = new ItemListViewCarrossel("Lucas Volgarini");
        ItemListViewCarrossel item3 = new ItemListViewCarrossel("Eduardo Ricoldi");
        ItemListViewCarrossel item4 = new ItemListViewCarrossel("Felipe Panngo");

        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);

        //Cria o adapter
       AdapterCarrossel adapterListView = new AdapterCarrossel(this, itens);

        //Define o Adapter
        listViewCarrossel.setAdapter(adapterListView);
    }
}
