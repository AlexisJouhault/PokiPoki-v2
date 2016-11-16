package pokemeows.pokipoki.data.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Toshiba on 8/11/2016.
 */

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
