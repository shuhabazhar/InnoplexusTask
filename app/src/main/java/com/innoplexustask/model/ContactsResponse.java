package com.innoplexustask.model;

import com.google.gson.annotations.SerializedName;
import com.innoplexustask.utils.Constant;

import org.json.JSONObject;

/**
 * Created by Shuhab abs-pc-2f-28 on 21/12/17.
 */

public class ContactsResponse {

    @SerializedName(Constant.ID)
    private
    String id;

    @SerializedName(Constant.NAME)
    private
    String name;

    @SerializedName(Constant.USER_NAME)
    private
    String userName;

    @SerializedName(Constant.EMAIL)
    private
    String email;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @SerializedName(Constant.ADDRESS)
    private
    Address address;

    @SerializedName(Constant.PHONE)
    private
    String phone;

    @SerializedName(Constant.WEBSITE)
    private
    String website;


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @SerializedName(Constant.COMPANY)
    private
    Company company;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

}
