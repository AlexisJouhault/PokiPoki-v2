package pokemeows.pokipoki.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pokemeows.pokipoki.PokiPokiApplication;
import pokemeows.pokipoki.R;
import pokemeows.pokipoki.adapters.MainFragmentPagerAdapter;
import pokemeows.pokipoki.contracts.MainContract;
import pokemeows.pokipoki.data.components.DaggerMainComponent;
import pokemeows.pokipoki.data.modules.MainModule;
import pokemeows.pokipoki.presenters.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject MainPresenter mPresenter;

    private MainFragmentPagerAdapter fragmentPagerAdapter;
    private Drawer drawer;
    private AccountHeader accountHeader;
    private ActionBarDrawerToggle mDrawerToggle;

    @BindView(R.id.fragment_viewpager)
    ViewPager fragmentViewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        DaggerMainComponent.builder()
                .netComponent(((PokiPokiApplication) getApplicationContext()).getNetComponent())
                .mainModule(new MainModule(this))
                .build().inject(this);

        this.fragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), this);
        this.fragmentViewPager.setAdapter(fragmentPagerAdapter);
        this.fragmentViewPager.setOffscreenPageLimit(4);
        this.tabLayout.setupWithViewPager(fragmentViewPager);

        try {
            buildProfile();
            setUpNavigationDrawer();
        } catch (Exception e) {
            Logger.d(e.getMessage());
        }
    }

    private void setUpNavigationDrawer() {

    }

    private void buildProfile() {
        // Create the AccountHeader

    }
}
