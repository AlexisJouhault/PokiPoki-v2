package pokemeows.pokipoki.data.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pokemeows.pokipoki.contracts.SetsContract;

/**
 * Created by Toshiba on 10/11/2016.
 */

@Module
public class SetsModule {

    private final SetsContract.View mSetsView;

    public SetsModule(SetsContract.View mSetsView) {
        this.mSetsView = mSetsView;
    }

    @Singleton
    @Provides
    public SetsContract.View provideSetsView() {
        return mSetsView;
    }
}
