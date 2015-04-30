package com.fasteque.hooray.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.fasteque.hooray.R;

/**
 * Created by danielealtomare on 30/04/15.
 */
public class AboutFragment extends PreferenceFragment {

    public AboutFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.about);
    }
}
