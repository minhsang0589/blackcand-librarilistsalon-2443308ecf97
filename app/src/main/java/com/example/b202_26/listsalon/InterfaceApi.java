package com.example.b202_26.listsalon;

import com.example.b202_26.listsalon.ItemList.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceApi {

    @GET("hodela/list_salon")
    Call<List> getList();
}
