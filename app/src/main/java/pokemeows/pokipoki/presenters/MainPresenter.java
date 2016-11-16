package pokemeows.pokipoki.presenters;

import javax.inject.Inject;

import pokemeows.pokipoki.contracts.MainContract;
import retrofit2.Retrofit;

/**
 * Created by Toshiba on 10/11/2016.
 */

public class MainPresenter implements MainContract.MainPresenter {

    Retrofit mRetrofit;
    MainContract.View mView;

    @Inject
    public MainPresenter(Retrofit mRetrofit, MainContract.View mView) {
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
