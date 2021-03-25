package com.example.lesson5_1dz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IFragment {
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        thirdFragment = new ThirdFragment();
        secondFragment = new SecondFragment();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frame_layout,thirdFragment);
        transaction.commit();
    }

    @Override
    public void hideFragment() {
        transaction = fragmentManager.beginTransaction();
        transaction.hide(secondFragment);
        transaction.commit();
    }

    @Override
    public void showFragment() {
        transaction = fragmentManager.beginTransaction();
        transaction.show(secondFragment);
        transaction.commit();
    }

    @Override
    public void addText(String text) {
        secondFragment = (SecondFragment) fragmentManager.findFragmentById(R.id.second_fragment);
        list.add(text);
        secondFragment.addList(list,this);
    }
}