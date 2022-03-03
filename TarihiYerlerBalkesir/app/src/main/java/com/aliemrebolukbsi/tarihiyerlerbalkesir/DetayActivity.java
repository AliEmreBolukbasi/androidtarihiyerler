package com.aliemrebolukbsi.tarihiyerlerbalkesir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        Intent intent = getIntent();
        if(intent!=null){
            //detay aktivitesi için view leri çağırdım
            ImageView img = (ImageView) findViewById(R.id.img1);
            TextView baslik = (TextView) findViewById(R.id.txtbaslik1);
            TextView tarih = (TextView) findViewById(R.id.txttarih1);
            TextView aciklama = (TextView) findViewById(R.id.txtaciklama1);

            img.setImageResource(intent.getIntExtra("resim",R.drawable.kazdaglarimilliparki));
            baslik.setText(intent.getStringExtra("yeradi"));
            tarih.setText(intent.getStringExtra("tarih"));
            aciklama.setText(intent.getStringExtra("aciklama"));

        }


    }
}