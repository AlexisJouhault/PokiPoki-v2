package pokemeows.pokipoki.presenters;

import javax.inject.Inject;

import pokemeows.pokipoki.contracts.EventsContract;
import retrofit2.Retrofit;

/**
 * Created by Toshiba on 10/11/2016.
 */

public class EventsPresenter implements EventsContract.EventsPresenter {

    Retrofit mRetrofit;
    EventsContract.View mView;

    @Inject
    public EventsPresenter(Retrofit mRetrofit, EventsContract.View mView) {
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
