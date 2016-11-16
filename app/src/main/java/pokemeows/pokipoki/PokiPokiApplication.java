package pokemeows.pokipoki;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.orhanobut.logger.Logger;

import pokemeows.pokipoki.data.components.DaggerNetComponent;
import pokemeows.pokipoki.data.components.NetComponent;
import pokemeows.pokipoki.data.modules.AppModule;
import pokemeows.pokipoki.data.modules.NetModule;
import pokemeows.pokipoki.utils.network.CardApi;

/**
 * Created by Toshiba on 8/11/2016.
 */

public class PokiPokiApplication extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());
        Logger.init();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(CardApi.BASE_URL))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
