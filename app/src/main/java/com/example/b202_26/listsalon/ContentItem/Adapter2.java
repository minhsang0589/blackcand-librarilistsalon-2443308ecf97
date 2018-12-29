package com.example.b202_26.listsalon.ContentItem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.b202_26.listsalon.ItemList.Adapter1;
import com.example.b202_26.listsalon.ItemList.ItemListActivity1;
import com.example.b202_26.listsalon.R;

import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.myHolder>{
    private Context mContext;
    private ArrayList<Service> getService;

    public Adapter2(Context mContext, ArrayList<Service> getService) {
        this.mContext = mContext;
        this.getService = getService;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.service_content_activity, viewGroup, false);
        return new Adapter2.myHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder viewHolder, int i) {
        viewHolder.tvService.setText(getService.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return getService.size();
    }

    public class myHolder extends RecyclerView.ViewHolder{
        TextView tvService;
        ImageView imgRight;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            tvService = (TextView)itemView.findViewById(R.id.tv_name_service);
            imgRight = (ImageView)itemView.findViewById(R.id.img_right);
        }
    }
}
