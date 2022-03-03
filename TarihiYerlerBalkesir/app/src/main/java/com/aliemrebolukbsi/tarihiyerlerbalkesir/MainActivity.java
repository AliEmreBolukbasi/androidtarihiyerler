package com.aliemrebolukbsi.tarihiyerlerbalkesir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste = (GridView) findViewById(R.id.gVyerlerlistesi);
        BalikesirAdapter listeadapter = new BalikesirAdapter(this);
        liste.setAdapter(listeadapter);
        liste.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,DetayActivity.class);
        //getview dan view tutucu tipinde veri döndürdüm
        Viewtutucu tutucu = (Viewtutucu) view.getTag();
        //tüm bilgiler için edremit tipinde  nesne oluşturdum
        // tag ile çektim
        Edremit tıklanılanresim=(Edremit)tutucu.resim.getTag();
        //intentlere putextra özelliği ekledim verilere arayüze yolladım
        intent.putExtra("resim",tıklanılanresim.resim);
        intent.putExtra("yeradi",tıklanılanresim.yeradi);
        intent.putExtra("tarih",tıklanılanresim.tarih);
        intent.putExtra("aciklama",tıklanılanresim.aciklama);

        startActivity(intent);
    }


}