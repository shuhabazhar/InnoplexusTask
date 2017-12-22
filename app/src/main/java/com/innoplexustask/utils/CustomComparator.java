package com.innoplexustask.utils;

import com.innoplexustask.model.ContactsResponse;

import java.util.Comparator;

/**
 * Created by Shuhab abs-pc-2f-28 on 22/12/17.
 */

public class CustomComparator implements Comparator<ContactsResponse> {
    @Override
    public int compare(ContactsResponse o1, ContactsResponse o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
