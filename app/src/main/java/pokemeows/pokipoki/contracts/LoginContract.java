package pokemeows.pokipoki.contracts;

import android.content.Intent;

import pokemeows.pokipoki.activities.LoginActivity;
import pokemeows.pokipoki.presenters.Presenter;

/**
 * Created by Toshiba on 9/11/2016.
 */

public interface LoginContract {

    interface View {
        public void startLogin();
        public void loginSuccess();
        public void loginFail();
    }

    interface LoginPresenter extends Presenter<View> {
        public void attachAuthListener();
        public void detachAuthListener();
        void processResult(int requestCode, int resultCode, Intent data);
    }
}
