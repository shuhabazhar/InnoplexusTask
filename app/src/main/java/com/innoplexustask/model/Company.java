package com.innoplexustask.model;

import com.google.gson.annotations.SerializedName;
import com.innoplexustask.utils.Constant;

/**
 * Created by Shuhab abs-pc-2f-28 on 21/12/17.
 */

public class Company {

    @SerializedName(Constant.COMPANY_NAME)
    private
    String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    @SerializedName(Constant.CATCH_PHRASE)
    private
    String catchPhrase;

    public String getBs() {
        return bs;
    }

    @SerializedName(Constant.BS)
    private
    String bs;
}
