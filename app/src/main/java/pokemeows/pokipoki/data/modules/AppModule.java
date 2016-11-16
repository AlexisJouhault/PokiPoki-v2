package pokemeows.pokipoki.data.modules;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pokemeows.pokipoki.data.scopes.AppScope;
import pokemeows.pokipoki.models.Card;

/**
 * Created by Toshiba on 8/11/2016.
 */

@Module
public class AppModule {

    Application mApplication;
    @Inject
    SharedPreferences sharedPreferences;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    SharedPreferences providesSP() {
        return sharedPreferences;
    }
}
