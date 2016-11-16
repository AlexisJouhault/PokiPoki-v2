package pokemeows.pokipoki.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import pokemeows.pokipoki.R;
import pokemeows.pokipoki.presenters.SignUpPresenter;
import pokemeows.pokipoki.views.SignUpView;

public class SignUpActivity extends PokiPokiActivity implements SignUpView {

    private SignUpPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        if (savedInstanceState == null) {
//            this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
