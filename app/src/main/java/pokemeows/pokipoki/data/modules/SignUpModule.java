package pokemeows.pokipoki.data.modules;

import dagger.Module;
import dagger.Provides;
import pokemeows.pokipoki.contracts.SignUpContract;
import pokemeows.pokipoki.data.scopes.SignUpScope;
import pokemeows.pokipoki.views.SignUpView;

/**
 * Created by Toshiba on 9/11/2016.
 */

@Module
public class SignUpModule {

    private final SignUpContract.View mSignUpView;

    public SignUpModule(SignUpContract.View mSignUpView) {
        this.mSignUpView = mSignUpView;
    }

    @Provides
    @SignUpScope
    SignUpContract.View provideSignUpView() {
        return mSignUpView;
    }

}
