package com.innoplexustask.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.innoplexustask.R;
import com.innoplexustask.activity.ContactDetailsActivity;
import com.innoplexustask.model.Address;
import com.innoplexustask.model.ContactsResponse;
import com.innoplexustask.utils.Constant;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Shuhab abs-pc-2f-28 on 21/12/17.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder> implements View.OnClickListener {
    Context context;
    private ArrayList<ContactsResponse> contactList;
    View view;
    public ContactListAdapter(Context context, ArrayList<ContactsResponse> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.adapter_contact_list, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.txtName.setText(contactList.get(position).getName());
        holder.txtPhone.setText(contactList.get(position).getPhone());
        view.setOnClickListener(this);
        view.setTag(position);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        Intent intent = new Intent(context, ContactDetailsActivity.class);
        intent.putExtra(Constant.NAME, contactList.get(position).getName());
        intent.putExtra(Constant.USER_NAME, contactList.get(position).getUserName());
        intent.putExtra(Constant.EMAIL, contactList.get(position).getEmail());
        intent.putExtra(Constant.PHONE, contactList.get(position).getPhone());
        intent.putExtra(Constant.WEBSITE, contactList.get(position).getWebsite());
        intent.putExtra(Constant.STREET, contactList.get(position).getAddress().getStreet());
        intent.putExtra(Constant.SUITE, contactList.get(position).getAddress().getSuite());
        intent.putExtra(Constant.CITY, contactList.get(position).getAddress().getCity());
        intent.putExtra(Constant.ZIPCODE, contactList.get(position).getAddress().getZipCode());
        intent.putExtra(Constant.COMPANY_NAME_DATA, contactList.get(position).getCompany().getCompanyName());
        intent.putExtra(Constant.CATCH_PHRASE, contactList.get(position).getCompany().getCatchPhrase());
        intent.putExtra(Constant.BS, contactList.get(position).getCompany().getBs());
        context.startActivity(intent);
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPhone;
        public ContactViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
        }
    }
}
