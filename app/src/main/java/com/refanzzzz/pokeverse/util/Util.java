package com.refanzzzz.pokeverse.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Locale;

public class Util {

    public static String capitalize(String text) {
        if(text == null || text.length() == 0) {
            return text;
        }

        return text.substring(0, 1).toUpperCase()+text.substring(1);
    }

    public static void setLocale(Activity activity, String language) {
        Resources resources = activity.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();

        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration, displayMetrics);
        activity.onConfigurationChanged(configuration);
    }

}
