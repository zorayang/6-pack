package edu.macalester.macathon.sixpack.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.macalester.macathon.sixpack.LoginActivity;
import edu.macalester.macathon.sixpack.R;

public class AccountFragment extends android.support.v4.app.Fragment {

    public static final String TAG = "FRAGMENT_ACCOUNT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_account, container, false);

        TextView tvAccountLogout = (TextView) rootView.findViewById(R.id.tvAccountLogout);
        tvAccountLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogOut();
            }
        });


        return rootView;
    }

    public void performLogOut() {
        Intent intentLogin = new Intent();
        intentLogin.setClass(getContext(), LoginActivity.class);
        startActivity(intentLogin);
    }

    public static AccountFragment getInstance() {
        return new AccountFragment();
    }
}
