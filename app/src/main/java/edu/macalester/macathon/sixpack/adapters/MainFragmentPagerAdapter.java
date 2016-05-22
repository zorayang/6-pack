package edu.macalester.macathon.sixpack.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;

import edu.macalester.macathon.sixpack.R;
import edu.macalester.macathon.sixpack.fragments.AccountFragment;
import edu.macalester.macathon.sixpack.fragments.CasinoFragment;
import edu.macalester.macathon.sixpack.fragments.ChallengeOthersFragment;
import edu.macalester.macathon.sixpack.fragments.DailyFeedFragment;
import edu.macalester.macathon.sixpack.fragments.MyChallengeFragment;

/**
 * Created by zoray on 2/19/16.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private Bundle fragmentBundle = null;

    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public MainFragmentPagerAdapter(FragmentManager fm, Context context, Bundle data) {
        super(fm);
        this.context = context;
        this.fragmentBundle = data;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MyChallengeFragment.getInstance();
            case 1:
                return ChallengeOthersFragment.getInstance();
            case 2:
                return DailyFeedFragment.getInstance();
            case 3:
                return CasinoFragment.getInstance();
            case 4:
                return AccountFragment.getInstance();
            default:
                return MyChallengeFragment.getInstance();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    private int[] imageResId = {
            R.mipmap.my_challenges,
            R.mipmap.challenge_others,
            R.mipmap.daily_challenge,
            R.mipmap.casino,
            R.mipmap.home
    };

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable icon = ContextCompat.getDrawable(context, imageResId[position]);
        icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
        SpannableString ss = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(icon, ImageSpan.ALIGN_BOTTOM);
        ss.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return ss;
    }
}
