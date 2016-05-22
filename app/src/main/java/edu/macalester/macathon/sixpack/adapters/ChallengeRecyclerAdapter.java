package edu.macalester.macathon.sixpack.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.macalester.macathon.sixpack.R;
import edu.macalester.macathon.sixpack.data.Challenge;

/**
 * Created by zoray on 2/20/16.
 */
public class ChallengeRecyclerAdapter extends RecyclerView.Adapter<ChallengeRecyclerAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvChalengeeName;
        public TextView tvReward;
        public CheckBox cbCompleted;
        public TextView tvChallengeDesc;
        public TextView tvCancel;


        public ViewHolder(View itemView) {
            super(itemView);
            tvChalengeeName = (TextView) itemView.findViewById(R.id.tv_add_challenge_challenger);
            tvReward = (TextView) itemView.findViewById(R.id.tv_add_challenge_amt);
            cbCompleted = (CheckBox) itemView.findViewById(R.id.cb_add_challenge_completed);
            tvCancel = (TextView) itemView.findViewById(R.id.tv_add_challenge_cancel);
            tvChallengeDesc = (TextView) itemView.findViewById(R.id.tv_add_challenge_desc);
        }
    }

    private List<Challenge> itemsList;
    private Context context;

    public ChallengeRecyclerAdapter(Context context, List<Challenge> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.challenge_row, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final Challenge item = itemsList.get(i);
        viewHolder.tvChalengeeName.setText(item.getChallengeeName());
        viewHolder.tvReward.setText(String.valueOf(item.getReward()));
        viewHolder.cbCompleted.setChecked(item.isCompleted());
        viewHolder.cbCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setCompleted(viewHolder.cbCompleted.isChecked());
                item.save();
            }
        });

        viewHolder.tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public void addChallenge(Challenge challenge) {
        challenge.save();
        itemsList.add(challenge);
        notifyDataSetChanged();
    }

    public void resetList() {
        this.itemsList = Challenge.listAll(Challenge.class);
        notifyDataSetChanged();
    }

    public void removeItem(int index) {
        // remove it from the DB
        itemsList.get(index).delete();
        // remove it from the list
        itemsList.remove(index);
        notifyDataSetChanged();
    }

    public void removeAllItems() {
        Challenge.deleteAll(Challenge.class);
        resetList();
    }

    public Challenge getChallenge(int i) {
        return itemsList.get(i);
    }
}

