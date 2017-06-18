package com.example.admin.retrofit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.retrofit.APIclient;
import com.example.admin.retrofit.R;
import com.example.admin.retrofit.adapter.API_interface;
import com.example.admin.retrofit.adapter.datalist;
import com.example.admin.retrofit.adapter.recyclerview_adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 5/31/2017.
 */

public class display_data extends AppCompatActivity {

    RecyclerView recyclerView;
    recyclerview_adapter adapter;
    List<datalist> list;
    API_interface api_interface;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        api_interface = new APIclient().getClient().create(API_interface.class);


        Call<List<datalist>> call = api_interface.getList();

        call.enqueue(new Callback<List<datalist>>() {
            @Override
            public void onResponse(Call<List<datalist>> call, Response<List<datalist>> response) {
                list = new ArrayList<>();


                List<datalist> datalists = response.body();

                for (int i = 0; i < datalists.size(); i++) {
                    datalist item = datalists.get(i);
                    list.add(item);
                }


                adapter = new recyclerview_adapter(list, context);
                recyclerView.setAdapter(adapter);
                DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), 1);
                recyclerView.addItemDecoration(itemDecoration);
                //Log.d("retrofitttt", response+"");
            }

            @Override
            public void onFailure(Call<List<datalist>> call, Throwable t) {

                Toast.makeText(context,"Failure", Toast.LENGTH_SHORT ).show();

            }
        });





    }
}
