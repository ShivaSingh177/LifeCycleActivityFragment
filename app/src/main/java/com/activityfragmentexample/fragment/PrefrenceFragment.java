package com.activityfragmentexample.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.activityfragmentexample.R;


/**
 * Created by esec-sruthi on 20/10/17.
 */

public class PrefrenceFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.prefrence);
    }
}