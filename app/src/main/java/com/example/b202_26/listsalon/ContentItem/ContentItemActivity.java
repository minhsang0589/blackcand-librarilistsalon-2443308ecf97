package com.example.b202_26.listsalon.ContentItem;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.b202_26.listsalon.InterfaceApi;
import com.example.b202_26.listsalon.ItemList.ItemListActivity1;
import com.example.b202_26.listsalon.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ContentItemActivity extends Activity {
    ImageView imgContentActi;
    Button btnBookContentActi;
    TextView tvNameContentActi,tvPhoneContentActi,tvClockContentActi,tvDetailContentActi,tvAdressContentActi;
    RecyclerView rvServiceContenActi;
    Adapter2 myAdapter2;
    ArrayList<Service> ServiceItem = new ArrayList<>();



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_item);
        init();
        rvServiceContenActi = (RecyclerView) findViewById(R.id.rv_service_contenActi);
        rvServiceContenActi.setLayoutManager(new LinearLayoutManager(this));
        myAdapter2 = new Adapter2(this,ServiceItem);
        rvServiceContenActi.setAdapter(myAdapter2);

        String k = getIntent().getStringExtra("aaa");
        Gson g = new Gson();
        ItemListActivity1 s = g.fromJson(k,ItemListActivity1.class);

        Relationships list = s.getRelationships();
        ServiceItem.addAll(list.getServices());
        myAdapter2.notifyDataSetChanged();

        String url = s.getImage_salon().get(0);
        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this).load(url)
                .into(imgContentActi);
        tvNameContentActi.setText(s.getName_salon());
        tvAdressContentActi.setText(s.getAddress());
        tvPhoneContentActi.setText(s.getPhone());
        tvClockContentActi.setText(s.getOpening_hours());
        tvDetailContentActi.setText(s.getDescription());

    }

    public void init(){
        btnBookContentActi = (Button)findViewById(R.id.btn_book_contentActi);
        tvNameContentActi = (TextView)findViewById(R.id.tv_name_contentActi);
        tvPhoneContentActi = (TextView)findViewById(R.id.tv_phone_contenActi);
        tvClockContentActi = (TextView)findViewById(R.id.tv_clock_contenActi);
        tvDetailContentActi = (TextView)findViewById(R.id.tv_detail_contentActi);
        tvAdressContentActi = (TextView)findViewById(R.id.tv_adress_contenActi);
        imgContentActi = (ImageView)findViewById(R.id.img_contentActi);
    }
}
