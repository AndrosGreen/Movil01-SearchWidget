package com.example.searchwidget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener  {

    List<ListElement> elements;
    SearchView txtBuscar;
    ListAdapter listAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBuscar = findViewById(R.id.txtBuscar1);
        txtBuscar.setOnQueryTextListener(this);

        init();
    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("Pikachu","Electrico"));
        elements.add(new ListElement("Squirtle","Agua"));
        elements.add(new ListElement("Charmander","Fuego"));
        elements.add(new ListElement("Drampa","Dragon"));
        elements.add(new ListElement("Regice","Hielo"));
        elements.add(new ListElement("Wailord","Agua"));
        elements.add(new ListElement("Lapras","Agua"));
        elements.add(new ListElement("Nidoqueen","Veneno"));
        elements.add(new ListElement("Vibrava","Dragon"));
        elements.add(new ListElement("Sharpedo","Siniestro"));
        elements.add(new ListElement("Ariados","Bicho"));
        elements.add(new ListElement("Altaria","Dragon"));
        elements.add(new ListElement("Snorlax","Normal"));
        elements.add(new ListElement("Ralts","Psiquico"));
        elements.add(new ListElement("Cubone","Tierra"));
        elements.add(new ListElement("Espeon","Psiquico"));
        elements.add(new ListElement("Aron","Metal"));
        elements.add(new ListElement("Charmeeleon","Fuego"));
        elements.add(new ListElement("Charizard","Fuego"));
        elements.add(new ListElement("Raichu","Electrico"));
        elements.add(new ListElement("Vaporeon","Agua"));
        elements.add(new ListElement("Flareon","Fuego"));
        elements.add(new ListElement("Jolteon","Electrico"));

        listAdapter = new ListAdapter(elements, this);
        recyclerView = findViewById(R.id.list_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        listAdapter.filtrado(s);
        return true;
    }

}