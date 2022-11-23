package com.refanzzzz.pokeverse.util;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Util {

    public static String capitalize(String text) {
        if(text == null || text.length() == 0) {
            return text;
        }

        return text.substring(0, 1).toUpperCase()+text.substring(1);
    }

}
