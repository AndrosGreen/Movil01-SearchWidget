package com.example.searchwidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElement> mData;
    private List<ListElement> mDataOriginal;

    private LayoutInflater mInflater;
    private Context contex;

    public ListAdapter(List<ListElement> itemList, Context contex){
        this.mInflater = LayoutInflater.from(contex);
        this.contex = contex;
        this.mData = itemList;
        mDataOriginal = new ArrayList<>();
        mDataOriginal.addAll(itemList);
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setItems(List<ListElement> items) {mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,tipo;

        ViewHolder(View itemView){
            super(itemView);
            nombre = itemView.findViewById(R.id.nombrePokemon);
            tipo = itemView.findViewById(R.id.tipoPokemon);
        }

        void bindData(final ListElement item){
            nombre.setText(item.getNombre());
            tipo.setText(item.getTipo());
        }

    }


    public void filtrado(final String txtBuscar){
        int len = txtBuscar.length();

        if(len == 0){
            mData.clear();
            mData.addAll(mDataOriginal);
        }
        else {
            ArrayList<ListElement> copiaOriginal = new ArrayList<>();
            ArrayList<ListElement> arr = new ArrayList<>();

            for(ListElement elem : mDataOriginal){
                if(elem.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())){
                    arr.add(elem);
                }
                copiaOriginal.add(elem);
            }
            mData.clear();
            mData.addAll(arr);
            mDataOriginal.clear();
            mDataOriginal.addAll(copiaOriginal);
            //mData.add(new ListElement("gengar","fantasma"));
        }
        //mData.add(new ListElement(txtBuscar,"fantasma"));
        notifyDataSetChanged();
    }
}
