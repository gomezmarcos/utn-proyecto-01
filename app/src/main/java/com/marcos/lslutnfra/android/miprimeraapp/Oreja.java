package com.marcos.lslutnfra.android.miprimeraapp;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/**
 * Created by android on 03/09/15.
 */
public class Oreja implements View.OnClickListener {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void onClick(View v) {
        Log.e(TAG, "hubo un click en la oreja");
        ViewParent parent = v.getParent();
    }
}
