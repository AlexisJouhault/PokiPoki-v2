package pokemeows.pokipoki.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import pokemeows.pokipoki.R;
import pokemeows.pokipoki.contracts.SetsContract;

/**
 * Created by Toshiba on 10/11/2016.
 */

public class EventsFragment extends MainTabFragment {

    @Inject
    SetsContract.SetsPresenter mPresenter;

    public static EventsFragment newInstance(String title) {
        EventsFragment eventsFragment = new EventsFragment();
        eventsFragment.setTitle(title);
//        Bundle bundle = new Bundle();
//        eventsFragment.setArguments(bundle);

        return eventsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_events, container, false);

        return mainView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
