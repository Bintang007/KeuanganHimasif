package com.example.brianr.keuanganhimasif;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuestDanaKeluar extends Fragment {
    int counter1,total1;
    private TextView total;
    private ListView listView;
    private TambahListAdapter adapter;
    private List<mTambah> mTambahs;
    TextView title;
    Typeface tf1;

    public GuestDanaKeluar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guest_dana_keluar, container, false);
        title = (TextView)view.findViewById(R.id.title);
        tf1 = Typeface.createFromAsset(getResources().getAssets(),"fonts/Roboto-Regular.ttf");
        title.setTypeface(tf1);
        total = (TextView)view.findViewById(R.id.total);
        total.setTypeface(tf1);
        TextViewAnimation(0,"556000",total);
        listView = (ListView)view.findViewById(R.id.list_masuk);
        mTambahs = new ArrayList<>();

        mTambahs.add(new mTambah(1,"Banner","19 Desember 2017","56000"));
        mTambahs.add(new mTambah(2,"Persiapan Makrab","23 Januari 2018","500000"));

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
    private void TextViewAnimation(int mulai, String total, final TextView text){
        counter1 = mulai;
        total1 = Integer.parseInt(total);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (counter1 < total1){
                    try{
                        Thread.sleep(3);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    text.post(new Runnable() {
                        @Override
                        public void run() {
                            text.setText(""+counter1);
                        }
                    });
                    counter1+=1000;
                }
            }
        }).start();
    }

}
