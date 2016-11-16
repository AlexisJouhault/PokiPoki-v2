package pokemeows.pokipoki.data.components;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import dagger.Component;
import pokemeows.pokipoki.data.modules.FirebaseModule;
import pokemeows.pokipoki.data.scopes.UserScope;

/**
 * Created by Toshiba on 9/11/2016.
 */

@UserScope
@Component(dependencies = {NetComponent.class, FirebaseModule.class})
public interface FirebaseComponent {

}
