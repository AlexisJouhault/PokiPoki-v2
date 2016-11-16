package pokemeows.pokipoki.data.components;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import pokemeows.pokipoki.activities.LoginActivity;
import pokemeows.pokipoki.data.modules.AppModule;
import pokemeows.pokipoki.data.modules.NetModule;
import pokemeows.pokipoki.data.scopes.NetScope;
import pokemeows.pokipoki.presenters.LoginPresenter;
import retrofit2.Retrofit;

/**
 * Created by Toshiba on 8/11/2016.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    SharedPreferences sharedPreferences();
    Retrofit retrofit();
}
