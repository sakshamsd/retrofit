package com.example.admin.retrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.retrofit.adapter.API_interface;
import com.example.admin.retrofit.adapter.datalist;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class insert_data extends AppCompatActivity {

    EditText name_edit, address_edit, email_edit, mobile_edit;
    Button save;
    Context context;
    private ProgressDialog pDialog;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        name_edit = (EditText) findViewById(R.id.name);
        address_edit = (EditText) findViewById(R.id.address);
        email_edit = (EditText) findViewById(R.id.email);
        mobile_edit = (EditText) findViewById(R.id.mobile);

        save = (Button) findViewById(R.id.insert);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);







        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insert();


            }
        });

    }

    public void insert() {

        API_interface api_interface = new APIclient().getClient().create(API_interface.class);

        datalist datalist = new datalist();

        datalist.setName(name_edit.getText().toString());
        datalist.setEmail(email_edit.getText().toString());
        datalist.setMobile(mobile_edit.getText().toString());
        datalist.setAddress(address_edit.getText().toString());

        Call<ResponseBody> call = api_interface.insertInfo(datalist.getName(), datalist.getEmail(),
                datalist.getAddress(), datalist.getMobile());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                hidepDialog();
                Log.d("onResponse", "" + response.code() +
                        "  response body "  + response.body() +
                        " responseError " + response.errorBody() + " responseMessage " +
                        response.message());

                Toast.makeText(context, name_edit+":Data Inserted",Toast.LENGTH_SHORT ).show();




            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                hidepDialog();
                Log.d("onFailure", t.toString());


            }
        });
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
