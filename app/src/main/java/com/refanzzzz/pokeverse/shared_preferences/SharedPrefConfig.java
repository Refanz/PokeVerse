package com.refanzzzz.pokeverse.shared_preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.refanzzzz.pokeverse.model.PokemonAbility;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class SharedPrefConfig {

    private final static String LANGUAGE_KEY = "language-code";

    public static void addLangInSharedPref(Context context, String langCode) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(LANGUAGE_KEY, langCode);
        editor.apply();
    }

    public static String getLangInSharedPref(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        String langCode = sharedPreferences.getString(LANGUAGE_KEY, "");

        return  langCode;
    }

//    private final static String ABILITY_LIST_KEY = "pokemon-ability-name";
//    private final static String ABILITY_COUNT_KEY = "pokemon-ability-count";

//    public static void addListInSharedPref(Context context, List<PokemonAbility.Ability> abilityNameList) {
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(abilityNameList);
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(ABILITY_LIST_KEY, jsonString);
//        editor.apply();
//    }
//
//    public static List<PokemonAbility.Ability> getListFromSharedPref(Context context) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        String jsonString = sharedPreferences.getString(ABILITY_LIST_KEY, "");
//
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<PokemonAbility.Ability>>() {}.getType();
//        List<PokemonAbility.Ability> list = gson.fromJson(jsonString, type);
//        return list;
//    }
//
//    public static void addCountAbilityInPref(Context context, int abilityCount) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(ABILITY_COUNT_KEY, abilityCount);
//        editor.apply();
//    }
//
//    public static int getCountAbilityInPref(Context context) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        int abilityCount = sharedPreferences.getInt(ABILITY_COUNT_KEY, 0);
//
//        return abilityCount;
//    }
}
