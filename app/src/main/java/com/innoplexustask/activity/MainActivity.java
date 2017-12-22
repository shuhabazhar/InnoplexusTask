package com.innoplexustask.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.innoplexustask.R;
import com.innoplexustask.adapter.ContactListAdapter;
import com.innoplexustask.model.ContactsResponse;
import com.innoplexustask.network.ApiClient;
import com.innoplexustask.network.ApiInterface;
import com.innoplexustask.network.ConnectivityReceiver;
import com.innoplexustask.utils.CustomComparator;
import com.innoplexustask.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rvContactList;
    ArrayList<ContactsResponse> contactList = new ArrayList<>();
    String TAG = MainActivity.class.getSimpleName();
    TextView noData;
    FloatingActionButton fab;
    Boolean isAscending = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initObjects();
        clickListeners();
        Boolean isConnected = checkNetworkConnection();
        if (isConnected) {
            fetchContacts();
        } else {
            Toast.makeText(this, "Sorry! Not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void clickListeners() {
        fab.setOnClickListener(this);
    }

    private void initObjects() {
        LinearLayoutManager llManager = new LinearLayoutManager(this);
        rvContactList.setLayoutManager(llManager);
    }

    private boolean checkNetworkConnection() {
        return ConnectivityReceiver.isConnected(this);
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Contact List");
        }
        rvContactList = findViewById(R.id.rvContactList);
        noData = findViewById(R.id.noData);
        fab = findViewById(R.id.fab);
    }

    private void fetchContacts() {

        Utils.showDialog(this, "Loading Contacts");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ArrayList<ContactsResponse>> call = apiService.getContacts();
        call.enqueue(new Callback<ArrayList<ContactsResponse>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<ContactsResponse>> call, Response<ArrayList<ContactsResponse>> response) {
                contactList = response.body();
                if (contactList != null && contactList.size() > 0) {
                    Collections.sort(contactList, new CustomComparator());
                    rvContactList.setVisibility(View.VISIBLE);
                    noData.setVisibility(View.GONE);
                    initAdapter();
                } else {
                    noData.setVisibility(View.VISIBLE);
                    rvContactList.setVisibility(View.GONE);
                }
                Utils.hideDialog();
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ContactsResponse>> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                Utils.hideDialog();
            }
        });
    }

    private void initAdapter() {
        ContactListAdapter contactListAdapter = new ContactListAdapter(this, contactList);
        rvContactList.setItemAnimator(new DefaultItemAnimator());
        rvContactList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvContactList.setAdapter(contactListAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                if (isAscending) {
                    Collections.sort(contactList, new CustomComparator());
                    fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.descending));
                    isAscending = false;
                } else {
                    Collections.sort(contactList, Collections.reverseOrder(new CustomComparator()));
                    fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ascending));
                    isAscending = true;
                }
                initAdapter();
                break;
        }
    }
}
