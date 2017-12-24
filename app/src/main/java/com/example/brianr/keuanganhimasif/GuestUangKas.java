package com.example.brianr.keuanganhimasif;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuestUangKas extends Fragment {
    private TextView total;
    private ListView listView;
    private TambahListAdapter adapter;
    private List<mTambah> mTambahs;
    TextView title;
    Typeface tf1;
    Spinner spinner;

    public GuestUangKas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guest_uang_kas, container, false);
        title = (TextView)view.findViewById(R.id.title);
        tf1 = Typeface.createFromAsset(getResources().getAssets(),"fonts/Roboto-Regular.ttf");
        title.setTypeface(tf1);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.Tanggal, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        listView = (ListView)view.findViewById(R.id.list_masuk);
        mTambahs = new ArrayList<>();

        mTambahs.add(new mTambah(1,"BRIAN","18 Januari 2018","10000"));
        mTambahs.add(new mTambah(2,"ELDI","23 Januari 2018","10000"));

        adapter = new TambahListAdapter(getActivity(),mTambahs);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTambah m = mTambahs.get(position);
                Toast.makeText(getActivity(),"clicked product id = "+adapter.getItemId(position)+"Uang + "+m.getUang(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
