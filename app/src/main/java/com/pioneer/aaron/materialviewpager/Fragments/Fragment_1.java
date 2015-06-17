package com.pioneer.aaron.materialviewpager.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.pioneer.aaron.materialviewpager.R;

/**
 * Created by Aaron on 6/17/15.
 */
public class Fragment_1 extends Fragment {
    private View rootView;
    private ObservableScrollView mScrollView;
    private boolean instanceLoaded = false;

    private TextView countTextView;

    public static Fragment_1 newInstance() {
        return new Fragment_1();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("Attach", "fragment 1 is attached");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_1_layout, container, false);
        countTextView = (TextView) rootView.findViewById(R.id.count_text_1);

        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
            Toast.makeText(getActivity(), "fragment 1 is visible", Toast.LENGTH_SHORT).show();
            if (countTextView == null) {
                Log.d("DEBUG", "counttextview is null");
            }
        }
    }

    private void init() {
        countTextView = (TextView) rootView.findViewById(R.id.count_text_1);
    }

    private void updateUI() {
        countTextView.append("ok");
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mScrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);
        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
    }
}
