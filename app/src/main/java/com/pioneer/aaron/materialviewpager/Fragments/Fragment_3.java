package com.pioneer.aaron.materialviewpager.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.pioneer.aaron.materialviewpager.R;

import java.util.TreeMap;

/**
 * Created by Aaron on 6/17/15.
 */
public class Fragment_3 extends Fragment {
    private View rootView;
    private ObservableScrollView mScrollView;
    private boolean instanceLoaded = false;

    private TextView countTextView;

    public static Fragment_3 newInstance() {
        return new Fragment_3();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("Attach", "fragment 3 is attached");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        rootView = inflater.inflate(R.layout.fragment_3_layout,
                (ViewGroup) getActivity().findViewById(R.id.materialViewPager), false);
        countTextView = (TextView) rootView.findViewById(R.id.count_text_3);
        instanceLoaded = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("onCreateView", "fragment 3 created");

        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && instanceLoaded) {
            updateUI();
        }
    }

    private void updateUI() {
        countTextView.append("\n" + "fragment 3");
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mScrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);
        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
    }
}
