package com.okan.multithreading.solutions.exercise2;

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

import java.util.concurrent.atomic.AtomicBoolean;

public class SolutionExercise2Fragment extends BaseFragment {
    public static Fragment newInstance() {
        return new SolutionExercise2Fragment();
    }

    private byte[] mDummyData;
    private final AtomicBoolean mCountAbort = new AtomicBoolean(false);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDummyData = new byte[50 * 1000 * 1000];
        return inflater.inflate(R.layout.fragment_exercise_2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        countScreenTime();
    }

    /**
     * abort working thread in fragment when onStop method called
     * with this you solve the memory leak problem
     */
    @Override
    public void onStop() {
        super.onStop();
        mCountAbort.set(true);
    }

    @Override
    protected String getScreenTitle() {
        return "Exercise 2";
    }

    private void countScreenTime() {

        mCountAbort.set(false);

        new Thread(() -> {
            int screenTimeSeconds = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                if (mCountAbort.get()) {
                    return;
                }
                screenTimeSeconds++;
                Log.d("Exercise 2", "screen time: " + screenTimeSeconds + "s");
            }
        }).start();
    }
}
