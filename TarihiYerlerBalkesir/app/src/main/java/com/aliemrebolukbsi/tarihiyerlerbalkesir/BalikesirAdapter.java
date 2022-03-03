package com.aliemrebolukbsi.tarihiyerlerbalkesir;


import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// EDREMİT TİPİNDE VERİLERİ ALMAK İÇİN CLASS VE YAPICI METODU OLUŞTURDUM
class Edremit{
    int resim;
    String yeradi;
    String tarih;
    String aciklama;

    Edremit(int img , String isim,String zaman,String metin){
        this.resim=img;
        this.yeradi=isim;
        this.tarih=zaman;
        this.aciklama = metin;
    }

}
// getview içerisinde sürekli findviewbyid çağırmamak
// için yapılan optimizasyon
class Viewtutucu{
    ImageView resim;
    TextView yeradi;
    TextView tarih;
    TextView aciklama;

    Viewtutucu(View view){
        resim = view.findViewById(R.id.img);
        yeradi = view.findViewById(R.id.txtbaslik);
        tarih = view.findViewById(R.id.txttarih);
        aciklama = view.findViewById(R.id.txtaciklama);
    }

}

public class BalikesirAdapter extends BaseAdapter{

    Context context;
    ArrayList<Edremit> tumyerler ;
    //gelen context değerini getview içine yollamak için
    //global bir context değişkeni atadım
    BalikesirAdapter (Context a){
        this.context = a;
        tumyerler = new ArrayList<Edremit>();
        //burada kaynakları getresources metodu yardımıyla çağırdım
        Resources bilgiler = a.getResources();
        String[] yeradlari = bilgiler.getStringArray(R.array.yeradlari);
        int [] yerresimleri =
                {R.drawable.kazdaglarimilliparki ,R.drawable.kazdagimuzesi,
                        R.drawable.hasanboguldu, R.drawable.etnografyamuzesi,
                        R.drawable.tahtakuslaretnografyamuzesi,
                        R.drawable.adramytteionantikkenti};
        String[] yertarihleri = bilgiler.getStringArray(R.array.txttarih);
        String[] yeraciklamalari = bilgiler.getStringArray(R.array.yeraciklama);

        for (int i=0 ; i<6 ; i++){
            Edremit gecici = new Edremit(yerresimleri[i],yeradlari[i]
                    ,yertarihleri[i],yeraciklamalari[i]);
            tumyerler.add(gecici);

        }
    }
    //ADAPTER İMPLEMENT ETTİK
    @Override
    public int getCount() {
        return tumyerler.size();
    }

    @Override
    public Object getItem(int position) {
        return tumyerler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //geri gelen view değerini kolon adlı değişkene attım
        View kolon = convertView;
        //bu tutucu aktiviteler arası oluşturduğum bir class nesnesi
        Viewtutucu tutucu ;
        //daha hızlı çalışması için inflate olayını if"in içerisine aldım
        //böylece gelen view öğesi sadece oluşan ilk öğeler için çalışır
        if (kolon==null){
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            kolon = inf.inflate(R.layout.kolon,parent,false);
            tutucu = new Viewtutucu(kolon);
            kolon.setTag(tutucu);
        }
        else { tutucu = (Viewtutucu) kolon.getTag(); }
        //gelen positionları geciye attım direkt kullanmkatan farkı yok :)
        Edremit gecici = tumyerler.get(position);
        //yapıcının içinde verdiğim verileri verilen positiondaki
        //tutucuya atıyorum
        tutucu.resim.setImageResource(gecici.resim);
        tutucu.yeradi.setText(gecici.yeradi);
        tutucu.tarih.setText(gecici.tarih);
        tutucu.aciklama.setText(gecici.aciklama);

        tutucu.resim.setTag(gecici);
        tutucu.yeradi.setTag(gecici);
        tutucu.tarih.setTag(gecici);
        tutucu.aciklama.setTag(gecici);
        //ilk ekrana verileri dönüyorum
        return kolon;
    }
}
