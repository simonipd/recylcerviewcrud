package com.example.recyclerviewcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView recyclerView;
    private TextInputEditText ilTexto;
    private Button btnAgregar, btnEditar, btnEliminar;
    private ArrayList<String> listaDatos;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        ilTexto = findViewById(R.id.tilTexto);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnAgregar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        listaDatos = new ArrayList<>();
        adapter = new Adapter(listaDatos);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAgregar:
                agregarList(ilTexto.getText().toString().trim().toUpperCase());
                break;
            case R.id.btnEliminar:
                eliminarList(ilTexto.getText().toString().trim().toUpperCase());
                break;
        }
    }


    public void agregarList(String s){
        if(!s.equals("")) {
            listaDatos.add(s);
            recyclerView.setAdapter(adapter);
            ilTexto.setText("");
            showToast("Válor agregado");
        }else {
            showToast("Campo vacío");
            ilTexto.requestFocus();
            ilTexto.setText("");
        }

    }


    public void eliminarList(String s){
        Iterator<String> it = listaDatos.iterator();
        if(!ilTexto.getText().toString().equals("")) {
            while (it.hasNext()) {
                String item = it.next();
                if (item.equals(s)) {
                    listaDatos.remove(item);
                    recyclerView.setAdapter(adapter);
                    ilTexto.setText("");
                    showToast("Válor eliminado");
                    break;
                }else{
                    showToast("Válor no encontrado");
                    ilTexto.setText("");
                }
            }
        }else{
            showToast("Campo Vacío");
            ilTexto.setText("");
        }
    }


    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

}