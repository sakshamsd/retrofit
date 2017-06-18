package com.example.admin.retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.retrofit.R;

import java.util.List;

/**
 * Created by Admin on 5/21/2017.
 */

public class recyclerview_adapter extends RecyclerView.Adapter<recyclerview_adapter.myViewHolder> {

    private List<datalist> datalist;
    Context context;

    public recyclerview_adapter(List<com.example.admin.retrofit.adapter.datalist> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }





    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(recyclerview_adapter.myViewHolder holder, int position) {

        holder.name.setText("Name:"+" "+datalist.get(position).getName());
        holder.address.setText("Address:"+" "+datalist.get(position).getAddress());
        holder.email.setText("Email:"+" "+datalist.get(position).getEmail());
        holder.mobile.setText("Mobile:"+" "+datalist.get(position).getMobile());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class myViewHolder extends ViewHolder  {

        TextView name, email, address, mobile;

        public myViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.dis_name);
            email = (TextView) itemView.findViewById(R.id.dis_email);
            mobile = (TextView) itemView.findViewById(R.id.dis_mobile);
            address = (TextView) itemView.findViewById(R.id.dis_address);
        }
    }
}

