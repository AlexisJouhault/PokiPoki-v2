package pokemeows.pokipoki.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.facebook.login.widget.LoginButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pokemeows.pokipoki.PokiPokiApplication;
import pokemeows.pokipoki.R;
import pokemeows.pokipoki.contracts.LoginContract;
import pokemeows.pokipoki.data.components.DaggerLoginComponent;
import pokemeows.pokipoki.data.modules.LoginModule;
import pokemeows.pokipoki.presenters.LoginPresenter;

public class LoginActivity extends PokiPokiActivity implements LoginContract.View {

    @Inject LoginPresenter mPresenter;

    @BindView(R.id.facebook_login_button)
    LoginButton mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        DaggerLoginComponent.builder()
                .netComponent(((PokiPokiApplication) getApplicationContext()).getNetComponent())
                .loginModule(new LoginModule(this))
                .build().inject(this);

        mPresenter.setUpFacebookLogin(mLoginButton);
    }

    @OnClick(R.id.sign_up_text)
    public void onSignUpClick(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attachAuthListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.detachAuthListener();
    }

    @Override
    public void startLogin() {
        showProgressDialog(getString(R.string.auth_start));
    }

    @Override
    public void loginSuccess() {
        hideProgressDialog();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void loginFail() {
        hideProgressDialog();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.processResult(requestCode, resultCode, data);
    }
}
