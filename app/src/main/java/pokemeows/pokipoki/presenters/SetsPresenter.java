package pokemeows.pokipoki.presenters;

import javax.inject.Inject;

import pokemeows.pokipoki.contracts.SetsContract;
import retrofit2.Retrofit;

/**
 * Created by Toshiba on 10/11/2016.
 */

public class SetsPresenter implements SetsContract.SetsPresenter {

    Retrofit mRetrofit;
    SetsContract.View mView;

    @Inject
    public SetsPresenter(Retrofit mRetrofit, SetsContract.View mView) {
        this.mRetrofit = mRetrofit;
        this.mView = mView;
    }

    @Override
    public void publish() {

    }

    @Override
    public void onDestroy() {

    }
}
