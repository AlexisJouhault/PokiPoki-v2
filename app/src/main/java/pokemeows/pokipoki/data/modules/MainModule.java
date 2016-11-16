package pokemeows.pokipoki.data.modules;

import dagger.Module;
import dagger.Provides;
import pokemeows.pokipoki.contracts.EventsContract;
import pokemeows.pokipoki.contracts.MainContract;
import pokemeows.pokipoki.contracts.SetsContract;
import pokemeows.pokipoki.data.scopes.MainScope;
import pokemeows.pokipoki.presenters.MainPresenter;
import retrofit2.Retrofit;

/**
 * Created by Toshiba on 10/11/2016.
 */

@Module
public class MainModule {

    private final MainContract.View mMainView;

    public MainModule(MainContract.View mMainView) {
        this.mMainView = mMainView;
    }


    @MainScope
    @Provides
    public MainContract.View provideMainView() {
        return mMainView;
    }
}
