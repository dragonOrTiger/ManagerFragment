package com.demo.syj.ManagerFragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Fragment fragment1 = new Fragment1();
        final Fragment fragment2 = new Fragment2();
        Button add_fragment1 = (Button) findViewById(R.id.add_fragment1);
        Button add_fragment2 = (Button) findViewById(R.id.add_fragment2);
        final Button remove_fragment2 = (Button) findViewById(R.id.remove_fragment2);
        Button replace_fragment2 = (Button) findViewById(R.id.replace_fragment2);
        add_fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(fragment1, "add_fragment1");
            }
        });
        add_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(fragment2, "add_fragment2");
            }
        });
        remove_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment("add_fragment2");
            }
        });
        replace_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(fragment2, "add_fragment1");
            }
        });
    }
    private void addFragment(Fragment fragment, String tag){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment, tag);
        transaction.commit();
    }
    private void removeFragment(String tag){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentByTag(tag);
        transaction.remove(fragment);
        transaction.commit();
    }
    private void replaceFragment(Fragment fragment, String tag){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, tag);
        transaction.commit(); 
    }
}
