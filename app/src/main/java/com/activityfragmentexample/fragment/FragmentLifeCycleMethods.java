package com.activityfragmentexample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activityfragmentexample.R;

import java.util.ArrayList;


public class FragmentLifeCycleMethods extends Fragment {


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v("result","frag_attach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("result","frag_create");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle savedInstanceState) {
        Log.v("result","frag_create view");
        View view=layoutInflater.inflate(R.layout.fragment_life_cycle_method,viewGroup,false);
        Bundle agrs=getArguments();
        String from=agrs.getString("from");
        ArrayList<String > list=agrs.getStringArrayList("list");
        Log.v("result",from);
        System.out.println("result"+list.size());
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v("result","frag_Activity Created");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("result","frag_Start");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("result","frag_Resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v("result","frag_Pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("result","frag_Stop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v("result","frag_DestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("result","frag_Destroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v("result","frag_Detach");
    }
}

