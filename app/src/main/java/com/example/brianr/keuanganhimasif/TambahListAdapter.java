package com.example.brianr.keuanganhimasif;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Brian R on 20/12/2017.
 */

public class TambahListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<mTambah> tambahItems;

    public TambahListAdapter(Activity activity, List<mTambah> tambahItems) {
        this.activity = activity;
        this.tambahItems = tambahItems;
    }

    @Override
    public int getCount() {
        return tambahItems.size();
    }

    @Override
    public Object getItem(int position) {
        return tambahItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Locale localeID = new Locale("in","ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        View v = View.inflate(activity,R.layout.listtambah,null);
        TextView judul = (TextView)v.findViewById(R.id.judul);
        TextView tanggal = (TextView)v.findViewById(R.id.tanggal);
        TextView uang = (TextView)v.findViewById(R.id.uang);

        mTambah m = tambahItems.get(position);
        judul.setText(m.getJudul());
        tanggal.setText(m.getTanggal());
        uang.setText(formatRupiah.format(Double.parseDouble(m.getUang())));

        v.setTag(m.getId());

        return v;
    }
}
