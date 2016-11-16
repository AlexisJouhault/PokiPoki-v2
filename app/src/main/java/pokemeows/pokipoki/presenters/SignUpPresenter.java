package pokemeows.pokipoki.presenters;

import android.app.Activity;

import javax.inject.Inject;

import pokemeows.pokipoki.activities.SignUpActivity;
import pokemeows.pokipoki.contracts.SignUpContract;
import retrofit2.Retrofit;

/**
 * Created by Toshiba on 7/11/2016.
 */

public class SignUpPresenter implements SignUpContract.SignUpPresenter {

    @Inject Retrofit retrofit;
    @Inject SignUpContract.View mView;

    public SignUpPresenter() {

    }

    @Override
    public void publish() {
        if (mView != null) {

        }
    }

    @Override
    public void onDestroy() {

    }
}
