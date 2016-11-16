package pokemeows.pokipoki.data.modules;

import dagger.Module;
import dagger.Provides;
import pokemeows.pokipoki.contracts.LoginContract;
import pokemeows.pokipoki.data.scopes.LoginScope;
import pokemeows.pokipoki.presenters.LoginPresenter;
import retrofit2.Retrofit;

/**
 * Created by Toshiba on 9/11/2016.
 */

@Module
public class LoginModule {

    private final LoginContract.View mLoginView;

    public LoginModule(LoginContract.View mLoginView) {
        this.mLoginView = mLoginView;
    }

    @Provides
    @LoginScope
    LoginContract.View provideLoginView() {
        return mLoginView;
    }
}
