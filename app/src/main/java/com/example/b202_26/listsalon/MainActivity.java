package com.example.b202_26.listsalon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.b202_26.listsalon.ItemList.Adapter1;
import com.example.b202_26.listsalon.ItemList.ItemListActivity1;
import com.example.b202_26.listsalon.ItemList.List;
import com.example.b202_26.listsalon.ItemList.LoginActivity;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Adapter1.OnIndex {
    RecyclerView mRecycler;
    Adapter1 myAdapter;
    Retrofit retrofit;
    InterfaceApi myRetrofitApi;
    ArrayList<ItemListActivity1> list = new ArrayList<>();
    String BASE_URL = "http://45.77.27.89:8088/api/";
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Intent mloginResult = getIntent();
//        String data_oginResult = mloginResult.getStringExtra("keyloginResult");
//        laythongtin();

        mRecycler = (RecyclerView) findViewById(R.id.rclv_list_salon);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new Adapter1(this, list, this);
        mRecycler.setAdapter(myAdapter);

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        myRetrofitApi = retrofit.create(InterfaceApi.class);

        myRetrofitApi.getList().enqueue(new Callback<List>() {
            @Override
            public void onResponse(Call<List> call, Response<List> response) {
                if (response.isSuccessful()) {
                    List li = response.body();
                    list.addAll(li.getData());
                    myAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List> call, Throwable t) {

            }
        });
    }

    @Override
    public void index(int i) {
        index = i;
    }

    LoginResult loginResult;
    public void laythongtin() {
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "user_photos", "public_profile"));
        GraphRequest.newMeRequest(
                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject json, GraphResponse response) {
                        if (response.getError() != null) {
                            // handle error
                            System.out.println("ERROR");
                        } else {
                            System.out.println("Success");
                            try {

                                String jsonresult = String.valueOf(json);
                                System.out.println("JSON Result" + jsonresult);

                                String str_email = json.getString("email");
                                String str_id = json.getString("id");
                                String str_firstname = json.getString("first_name");
                                String str_lastname = json.getString("last_name");

                                Log.d("aadress", str_email + " " + str_firstname);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }).executeAsync();
    }
}
