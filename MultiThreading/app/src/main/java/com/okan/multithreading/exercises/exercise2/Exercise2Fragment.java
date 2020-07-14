package com.okan.multithreading.exercises.exercise2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.okan.multithreading.R;
import com.okan.multithreading.common.BaseFragment;

public class Exercise2Fragment extends BaseFragment {

    public static Fragment newInstance() {
        return new Exercise2Fragment();
    }

    private byte[] mDummyData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mDummyData = new byte[50 * 1000 * 1000];
        return inflater.inflate(R.layout.fragment_exercise_2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        countScreenTime();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    protected String getScreenTitle() {
        return "Exercise 2";
    }

    /**
     * when you come back from this fragment thread is still working
     * and this is a problem
     */

    private void countScreenTime() {
        new Thread(() -> {
            int screenTimeSeconds = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                screenTimeSeconds++;
                Log.d("Exercise 2", "screen time: " + screenTimeSeconds + "s");
            }
        }).start();
    }
}
