package com.refanzzzz.pokeverse.fragment;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.refanzzzz.pokeverse.R;

import java.util.Locale;

public class SettingsFragment extends Fragment {

    private View view;
    private RadioGroup rgLanguage;
    private RadioButton rdEnglish, rdIndonesia;
    private AppCompatTextView tvLanguage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);

        hideActionBar();

        init();

        initListener();

        return view;
    }

    void hideActionBar() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    void initListener() {
        rgLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rd_indonesia) {
                    setLocale("id");
                } else if (i == R.id.rd_english) {
                    setLocale("en");
                }
            }
        });
    }

    void setLocale(String language) {
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration, displayMetrics);
        onConfigurationChanged(configuration);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    void init() {
        rgLanguage = view.findViewById(R.id.rg_language);
        rdEnglish = view.findViewById(R.id.rd_english);
        rdIndonesia = view.findViewById(R.id.rd_indonesia);
    }
}