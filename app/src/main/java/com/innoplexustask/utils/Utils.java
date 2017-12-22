package com.innoplexustask.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Shuhab abs-pc-2f-28 on 22/12/17.
 */

public class Utils {
    private static ProgressDialog dialog = null;


    public static void showDialog(Context context, String msg) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog = new ProgressDialog(context);
        dialog.setMessage(msg);
        dialog.setCancelable(true);
        dialog.show();
    }

    public static void hideDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
