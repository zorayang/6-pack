package edu.macalester.macathon.sixpack.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import edu.macalester.macathon.sixpack.R;


public class MyChallengeFragment extends android.support.v4.app.Fragment {

    public static final String TAG = "FRAGMENT_MY_CHALLENGE";

    private ScrollView layoutContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_my_challenge, container, false);

        layoutContent = (ScrollView) rootView.findViewById(R.id.sv_my_challenge_challenge_layout);

        return rootView;
    }


    public static MyChallengeFragment getInstance() {
        return new MyChallengeFragment();
    }
}
