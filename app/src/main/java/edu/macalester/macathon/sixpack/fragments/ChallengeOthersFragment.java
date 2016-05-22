package edu.macalester.macathon.sixpack.fragments;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import edu.macalester.macathon.sixpack.AddChallengeActivity;
import edu.macalester.macathon.sixpack.MainActivity;
import edu.macalester.macathon.sixpack.R;
import edu.macalester.macathon.sixpack.adapters.ChallengeRecyclerAdapter;
import edu.macalester.macathon.sixpack.data.Challenge;

public class ChallengeOthersFragment extends android.support.v4.app.Fragment {

    public static final String TAG = "FRAGMENT_CHALLENGE_OTHERS";
    public static final int REQUEST_NEW_CHALLENGE = 101;
    private ChallengeRecyclerAdapter itemsAdapter;
    List<Challenge> challengesList = Challenge.listAll(Challenge.class);

    private LinearLayout layoutContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_challenge_others, container, false);


        itemsAdapter = new ChallengeRecyclerAdapter(getActivity(), challengesList);
        RecyclerView recyclerViewItems = (RecyclerView) rootView.findViewById(
                R.id.recycler_view);
        recyclerViewItems.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewItems.setAdapter(itemsAdapter);


        // add floating button
        FloatingActionButton fabAdd = (FloatingActionButton) rootView.findViewById(R.id.btnAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddChallengeActivity();
            }
        });

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_NEW_CHALLENGE) {
            Challenge challenge = (Challenge) data.getSerializableExtra(
                    AddChallengeActivity.KEY_CHALLENGE);
            itemsAdapter.addChallenge(challenge);
            itemsAdapter.notifyDataSetChanged();
        }

    }

    private void showAddChallengeActivity() {
        Intent intentStart = new Intent(getActivity(),
                AddChallengeActivity.class);
        startActivityForResult(intentStart, REQUEST_NEW_CHALLENGE);
    }

    public static ChallengeOthersFragment getInstance() {
        return new ChallengeOthersFragment();
    }
}
