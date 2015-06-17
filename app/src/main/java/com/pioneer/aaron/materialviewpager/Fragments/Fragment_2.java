package com.pioneer.aaron.materialviewpager.Fragments;

import android.app.Activity;
import android.os.AsyncTask;
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

/**
 * Created by Aaron on 6/17/15.
 */
public class Fragment_2 extends Fragment {
    private View rootView;
    private ObservableScrollView mScrollView;
    private boolean instanceLoaded = false;

    private TextView countTextView;

    public static Fragment_2 newInstance() {
        return new Fragment_2();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("Attach", "fragment 2 is attached");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_1_layout, container, false);
        init();
        return rootView;
    }

    private void init() {
        countTextView = (TextView) rootView.findViewById(R.id.count_text_1);
        new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] params) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                countTextView.append("ok");

            }
        }.execute();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mScrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);
        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
    }
}
