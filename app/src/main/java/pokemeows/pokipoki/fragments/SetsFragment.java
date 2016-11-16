package pokemeows.pokipoki.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import pokemeows.pokipoki.R;
import pokemeows.pokipoki.contracts.EventsContract;

/**
 * Created by Toshiba on 10/11/2016.
 */

public class SetsFragment extends MainTabFragment {

    @Inject
    EventsContract.EventsPresenter mPresenter;

    public static SetsFragment newInstance(String title) {
        SetsFragment setsFragment = new SetsFragment();
        setsFragment.setTitle(title);

//        Bundle bundle = new Bundle();
//        setsFragment.setArguments(bundle);

        return setsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_sets, container, false);

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
