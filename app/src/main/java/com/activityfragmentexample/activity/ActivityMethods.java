package com.activityfragmentexample.activity;

import android.app.DialogFragment;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.activityfragmentexample.R;
import com.activityfragmentexample.fragment.Dialogfrag;
import com.activityfragmentexample.fragment.FragmentLifeCycleMethods;
import com.activityfragmentexample.fragment.ListFrag;
import com.activityfragmentexample.fragment.PrefrenceFragment;

import java.util.ArrayList;

public class ActivityMethods  extends AppCompatActivity implements View.OnClickListener{
    private Button dialog_frag,list_frag,pref_frag;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private ArrayList<String > list=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods);
        dialog_frag=(Button)findViewById(R.id.btn_dialog_frag);
        list_frag=(Button)findViewById(R.id.btn_list_frag);
        pref_frag=(Button)findViewById(R.id.btn_prefrence_frag);
        dialog_frag.setOnClickListener(this);
        list_frag.setOnClickListener(this);
        pref_frag.setOnClickListener(this);



        dialog_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(ActivityAllmethods.this,FragmentNewActvity.class);
//                startActivity(i);
//                Dialogfrag dialogFragment=new Dialogfrag();
//                dialogFragment.show(fm,"Dialog Frag");

                fragmentLoad(new Dialogfrag());
            }
        });
        fragmentLoad(new FragmentLifeCycleMethods());

        list.add("one");
        list.add("Two");
        list.add("three");
        Log.v("result","create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("result","start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("result","resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("result","pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("result","stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("result","destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("result","restart");
    }

    private void fragmentLoad(Fragment fragment) {
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        //send bundel
        Bundle bundle=new Bundle();
        bundle.putStringArrayList("list",list);
        bundle.putString("from","activity");
        fragment.setArguments(bundle);
        ft.replace(R.id.frame_layout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dialog_frag:
                Dialogfrag dialogFragment=new Dialogfrag();
                dialogFragment.show(fm,"Dialog Frag");
                break;
            case R.id.btn_list_frag:
                fragmentLoad(new ListFrag());
                break;
            case R.id.btn_prefrence_frag:
                getFragmentManager().beginTransaction().replace(R.id.frame_layout,new PrefrenceFragment()).commit();
                break;
        }
    }
}
