package com.okan.multithreading.common;

import com.okan.multithreading.exercises.exercise1.Exercise1Fragment;
import com.okan.multithreading.home.HomeFragment;
import com.okan.multithreading.solutions.SolutionExercise1Fragment;
import com.techyourchance.fragmenthelper.FragmentHelper;


public class ScreensNavigator {

    private final FragmentHelper mFragmentHelper;

    public ScreensNavigator(FragmentHelper fragmentHelper) {
        mFragmentHelper = fragmentHelper;
    }

    public void navigateBack() {
        mFragmentHelper.navigateBack();
    }

    public void navigateUp() {
        mFragmentHelper.navigateUp();
    }

    public void toHomeScreen() {
        mFragmentHelper.replaceFragmentAndClearHistory(HomeFragment.newInstance());
    }

    public void toExercise1Screen() {
       // mFragmentHelper.replaceFragment(Exercise1Fragment.newInstance());
        mFragmentHelper.replaceFragment(SolutionExercise1Fragment.newInstance());
    }

    public void toExercise2Screen() {
        //mFragmentHelper.replaceFragment(Exercise2Fragment.newInstance());
    }

    public void toUiThreadDemonstration() {
        //mFragmentHelper.replaceFragment(UiThreadDemonstrationFragment.newInstance());
    }

    public void toUiHandlerDemonstration() {
        //mFragmentHelper.replaceFragment(UiHandlerDemonstrationFragment.newInstance());
    }

    public void toCustomHandlerDemonstration() {
        //mFragmentHelper.replaceFragment(CustomHandlerDemonstrationFragment.newInstance());
    }

    public void toExercise3Screen() {
        // mFragmentHelper.replaceFragment(Exercise3Fragment.newInstance());
    }

    public void toAtomicityDemonstration() {
        //mFragmentHelper.replaceFragment(AtomicityDemonstrationFragment.newInstance());
    }

    public void toExercise4Screen() {
        //mFragmentHelper.replaceFragment(Exercise4Fragment.newInstance());
    }

    public void toThreadWaitDemonstration() {
        //mFragmentHelper.replaceFragment(ThreadWaitDemonstrationFragment.newInstance());
    }

    public void toExercise5Screen() {
        //mFragmentHelper.replaceFragment(Exercise5Fragment.newInstance());
    }

    public void toDesignWithThreadsDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithThreadsDemonstrationFragment.newInstance());
    }

    public void toExercise6Screen() {
        //mFragmentHelper.replaceFragment(Exercise6Fragment.newInstance());
    }

    public void toDesignWithThreadPoolDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithThreadPoolDemonstrationFragment.newInstance());
    }

    public void toExercise7Screen() {
        //mFragmentHelper.replaceFragment(Exercise7Fragment.newInstance());
    }

    public void toDesignWithAsyncTaskDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithAsyncTaskDemonstrationFragment.newInstance());
    }

    public void toThreadPosterDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithThreadPosterDemonstrationFragment.newInstance());
    }

    public void toExercise8Screen() {
        //mFragmentHelper.replaceFragment(Exercise8Fragment.newInstance());
    }

    public void toDesignWithRxJavaDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithRxJavaDemonstrationFragment.newInstance());
    }

    public void toExercise9Screen() {
        //mFragmentHelper.replaceFragment(Exercise9Fragment.newInstance());
    }

    public void toDesignWithCoroutinesDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithCoroutinesDemonstrationFragment.Companion.newInstance());
    }

    public void toExercise10Screen() {
        //mFragmentHelper.replaceFragment(Exercise10Fragment.Companion.newInstance());
    }
}
