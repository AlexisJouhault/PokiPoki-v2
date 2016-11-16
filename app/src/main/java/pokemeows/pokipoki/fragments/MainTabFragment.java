package pokemeows.pokipoki.fragments;

import android.app.Activity;
import android.content.Context;

import pokemeows.pokipoki.activities.MainActivity;

/**
 * Created by alexisjouhault on 6/24/16.
 * ~~PokiPoki project~~
 */
public class MainTabFragment extends BaseFragment {

    protected Context mContext;
    protected String mTitle;

    @Override
    public void onAttach(Context context) {
        this.mContext = context;
        super.onAttach(context);
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getTitle() {
        return mTitle;
    }
}
