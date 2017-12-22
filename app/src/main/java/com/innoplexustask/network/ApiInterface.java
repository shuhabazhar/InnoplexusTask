package com.innoplexustask.network;

import com.innoplexustask.model.ContactsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Shuhab abs-pc-2f-28 on 21/12/17.
 */

public interface ApiInterface {

    @GET("/users")
    Call<ArrayList<ContactsResponse>> getContacts();
}
