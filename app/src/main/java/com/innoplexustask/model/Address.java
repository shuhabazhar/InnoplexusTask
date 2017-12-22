package com.innoplexustask.model;

import com.google.gson.annotations.SerializedName;
import com.innoplexustask.utils.Constant;

/**
 * Created by Shuhab abs-pc-2f-28 on 21/12/17.
 */

public class Address {

    @SerializedName(Constant.STREET)
    private
    String street;

    @SerializedName(Constant.SUITE)
    private
    String suite;

    @SerializedName(Constant.CITY)
    private
    String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @SerializedName(Constant.ZIPCODE)
    private
    String zipCode;
}
