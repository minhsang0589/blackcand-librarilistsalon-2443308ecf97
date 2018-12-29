package com.example.b202_26.listsalon.ItemList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.b202_26.listsalon.ContentItem.ContentItemActivity;
import com.example.b202_26.listsalon.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter1  extends RecyclerView.Adapter<Adapter1.Holder>{

    private Context mContext;
    private ArrayList<ItemListActivity1> getItem;
    private OnIndex onClickIndex;
    public Adapter1 (Context c, ArrayList<ItemListActivity1> list,OnIndex onClickIndex){
        mContext=c;
        getItem = list;
        this.onClickIndex=onClickIndex;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        holder.tvName.setText(getItem.get(i).getName_salon());
        holder.tvAdress.setText(getItem.get(i).getAddress());

        String url = getItem.get(i).getImage_salon().get(0);
        Picasso.with(mContext).setLoggingEnabled(true);
        Picasso.with(mContext).load(url)
                .into(holder.imgHinh);

        holder.btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickIndex.index(i);
                ItemListActivity1 s = getItem.get(i);
                Intent i = new Intent(v.getContext(),ContentItemActivity.class);
                Activity activity = (Activity)mContext;
                Gson gs = new Gson();
                String d = gs.toJson(s);
                i.putExtra("aaa",d);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getItem.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        ImageView imgHinh;
        TextView tvName,tvAdress;
        Button btnBook;
        public Holder(@NonNull View itemView) {
            super(itemView);

            imgHinh = (ImageView)itemView.findViewById(R.id.imv_Hinh);
            tvName = (TextView)itemView.findViewById(R.id.tv_Name);
            tvAdress = (TextView)itemView.findViewById(R.id.tv_Adress);
            btnBook = (Button)itemView.findViewById(R.id.btn_Book);
        }
    }
    public interface OnIndex{
        void index ( int i);
    }
}
