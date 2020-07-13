package com.okan.multithreading.common;

import android.os.Bundle;
import android.view.View;

import com.okan.multithreading.MyApplication;
import com.okan.multithreading.common.dependencyinjection.PresentationCompositionRoot;
import com.okan.multithreading.home.HomeFragment;
import com.techyourchance.fragmenthelper.HierarchicalFragment;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment implements HierarchicalFragment {

    private PresentationCompositionRoot mPresentationCompositionRoot;

    protected final PresentationCompositionRoot getCompositionRoot() {
        if (mPresentationCompositionRoot == null) {
            mPresentationCompositionRoot = new PresentationCompositionRoot(
                    requireActivity(),
                    ((MyApplication)requireActivity().getApplication()).getApplicationCompositionRoot()
            );
        }
        return mPresentationCompositionRoot;
    }

    @Nullable
    @Override
    public Fragment getHierarchicalParentFragment() {
        return HomeFragment.newInstance();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ToolbarManipulator toolbarManipulator = getCompositionRoot().getToolbarManipulator();
        toolbarManipulator.setScreenTitle(getScreenTitle());
        if (getHierarchicalParentFragment() != null) {
            toolbarManipulator.showUpButton();
        } else {
            toolbarManipulator.hideUpButton();
        }
    }

    protected abstract String getScreenTitle();

}
