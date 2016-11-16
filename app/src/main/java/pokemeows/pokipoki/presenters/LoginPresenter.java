package pokemeows.pokipoki.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import pokemeows.pokipoki.contracts.LoginContract;
import retrofit2.Retrofit;

/**
 * Created by Toshiba on 7/11/2016.
 */

public class LoginPresenter implements LoginContract.LoginPresenter {

    private final String TAG = LoginPresenter.class.toString();

    Retrofit mRetrofit;
    LoginContract.View mView;

    private CallbackManager mCallbackManager;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStatesListener;

    @Inject
    public LoginPresenter(Retrofit retrofit, LoginContract.View mView) {
        this.mRetrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void publish() {
        if (mView != null) {

        }
    }

    public void setUpFacebookLogin(LoginButton loginButton) {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mCallbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Logger.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Logger.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Logger.d(TAG, "facebook:onError", error);
                // ...
            }
        });
        mAuthStatesListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    mView.loginSuccess();
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    @Override
    public void attachAuthListener() {
        mFirebaseAuth.addAuthStateListener(mAuthStatesListener);
    }

    @Override
    public void detachAuthListener() {
        if (mAuthStatesListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStatesListener);
        }
    }

    @Override
    public void processResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {

    }

    private void handleFacebookAccessToken(AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        mView.startLogin();
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener((Activity) mView, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText((Context) mView, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            mView.loginFail();
                        } else {
                            mView.loginSuccess();
                        }
                    }
                });
    }
}