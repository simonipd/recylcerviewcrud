package com.example.recyclerviewcrud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderAdapter> {


    ArrayList<String> listaDatos;


    public Adapter(ArrayList<String> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,null,false);
        return new ViewHolderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter holder, int position) {
        holder.setData(listaDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {
        TextView txtTexto;

        public ViewHolderAdapter(@NonNull View itemView) {
            super(itemView);
            txtTexto = itemView.findViewById(R.id.txtDato);
        }

        public void setData(String s) {
            txtTexto.setText(s);
        }
    }
}
