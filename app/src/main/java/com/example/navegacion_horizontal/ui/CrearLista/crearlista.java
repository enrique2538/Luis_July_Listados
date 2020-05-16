package com.example.navegacion_horizontal.ui.CrearLista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.navegacion_horizontal.R;

import java.util.ArrayList;

public class crearlista extends Fragment {
    TextView textView;
    private GalleryViewModel galleryViewModel;

    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;
    private ListView list;
    private Button button;
    private EditText edit_item;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragmentocrear, container, false);
        final TextView textView = root.findViewById(R.id.crearlistapadre);

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        //return root;

        View view = inflater.inflate(R.layout.fragmentocrear, container, false);

        list = (ListView) root.findViewById(R.id.list);
        button = (Button) root.findViewById(R.id.button);
        edit_item = (EditText) root.findViewById(R.id.edit_item);

        itemList = new ArrayList<>();
        itemList.add("Leche Purita");
        itemList.add("Leche Entera");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, itemList);
        list.setAdapter(adapter);


        return root;

    }


    //public crearlista(){


    //}



}
