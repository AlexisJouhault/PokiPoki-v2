package pokemeows.pokipoki.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import pokemeows.pokipoki.R;
import pokemeows.pokipoki.fragments.EventsFragment;
import pokemeows.pokipoki.fragments.MainTabFragment;
import pokemeows.pokipoki.fragments.SetsFragment;

/**
 * Created by alexisjouhault on 6/24/16.
 * ~~PokiPoki project~~
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    List<MainTabFragment> fragmentList = new ArrayList<>();

    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        fragmentList.add(EventsFragment.newInstance(context.getString(R.string.events_title)));
        fragmentList.add(SetsFragment.newInstance(context.getString(R.string.sets_title)));
//        fragmentList.add(new CardsFragment());
    }

    public void addFragment(MainTabFragment fragment) {
        fragmentList.add(fragment);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        if (position < fragmentList.size()) {
            return fragmentList.get(position);
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position < fragmentList.size()) {
            return fragmentList.get(position).getTitle();
        }
        return "Tab " + position;
    }
}
