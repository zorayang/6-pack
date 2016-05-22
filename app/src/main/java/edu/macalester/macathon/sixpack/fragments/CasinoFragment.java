package edu.macalester.macathon.sixpack.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.macalester.macathon.sixpack.R;
public class CasinoFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_casino, container, false);

        return rootView;
    }


    public static CasinoFragment getInstance() {
        return new CasinoFragment();
    }
}
