package com.innoplexustask.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.innoplexustask.R;
import com.innoplexustask.utils.Constant;

public class ContactDetailsActivity extends AppCompatActivity {
    TextView txtName, txtUserName, txtEmail, txtPhone, txtWebsite, txtStreet,
            txtSuit, txtCity, txtZipcode, txtCompanyName, txtCatchPhrase, txtBs;
    String name, userName, email , phone , website, street, suite, city, zipCode,
            companyName, catchPhrase, bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        initViews();
        getBundleData();
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Contact Details");
        }
        txtName = findViewById(R.id.txtName);
        txtUserName = findViewById(R.id.txtUserName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtWebsite = findViewById(R.id.txtWebsite);
        txtStreet = findViewById(R.id.txtStreet);
        txtSuit = findViewById(R.id.txtSuite);
        txtCity = findViewById(R.id.txtCity);
        txtZipcode = findViewById(R.id.txtZipCode);
        txtCompanyName = findViewById(R.id.txtCompanyName);
        txtCatchPhrase = findViewById(R.id.txtCatchPhrase);
        txtBs = findViewById(R.id.txtBs);
    }

    private void getBundleData() {
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString(Constant.NAME);
        userName = bundle.getString(Constant.USER_NAME);
        email = bundle.getString(Constant.EMAIL);
        phone = bundle.getString(Constant.PHONE);
        website = bundle.getString(Constant.WEBSITE);
        street = bundle.getString(Constant.STREET);
        suite = bundle.getString(Constant.SUITE);
        city = bundle.getString(Constant.CITY);
        zipCode = bundle.getString(Constant.ZIPCODE);
        companyName = bundle.getString(Constant.COMPANY_NAME_DATA);
        catchPhrase = bundle.getString(Constant.CATCH_PHRASE);
        bs = bundle.getString(Constant.BS);
        setViews();
    }

    private void setViews() {
        txtName.setText(name);
        txtUserName.setText(userName);
        txtEmail.setText(email);
        txtPhone.setText(phone);
        txtWebsite.setText(website);
        txtStreet.setText(street);
        txtSuit.setText(suite);
        txtCity.setText(city);
        txtZipcode.setText(zipCode);
        txtCompanyName.setText(companyName);
        txtCatchPhrase.setText(catchPhrase);
        txtBs.setText(bs);
    }
}
