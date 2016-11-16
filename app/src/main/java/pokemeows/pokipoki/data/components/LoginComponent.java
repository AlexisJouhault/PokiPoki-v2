package pokemeows.pokipoki.data.components;

import dagger.Component;
import pokemeows.pokipoki.activities.LoginActivity;
import pokemeows.pokipoki.data.modules.LoginModule;
import pokemeows.pokipoki.data.scopes.LoginScope;

/**
 * Created by Toshiba on 9/11/2016.
 */

@LoginScope
@Component(dependencies = {NetComponent.class}, modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
