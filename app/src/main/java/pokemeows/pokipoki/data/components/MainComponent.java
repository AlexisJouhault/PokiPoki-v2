package pokemeows.pokipoki.data.components;

import dagger.Component;
import pokemeows.pokipoki.activities.MainActivity;
import pokemeows.pokipoki.data.modules.MainModule;
import pokemeows.pokipoki.data.scopes.MainScope;

/**
 * Created by Toshiba on 10/11/2016.
 */

@MainScope
@Component(dependencies = {NetComponent.class}, modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
