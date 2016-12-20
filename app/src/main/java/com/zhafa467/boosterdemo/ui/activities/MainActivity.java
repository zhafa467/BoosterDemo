package com.zhafa467.boosterdemo.ui.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.squareup.otto.Subscribe;
import com.zhafa467.boosterdemo.R;
import com.zhafa467.boosterdemo.common.BusProvider;
import com.zhafa467.boosterdemo.common.InvestorTypeScheme;
import com.zhafa467.boosterdemo.common.UpdateUIEvent;
import com.zhafa467.boosterdemo.ui.fragments.InvestorDetailsFragment;
import com.zhafa467.boosterdemo.ui.fragments.QuestionnaireFragment;
import com.zhafa467.boosterdemo.ui.fragments.SubmissionFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fan zhang on 16/12/20.
 */

public class MainActivity extends AppCompatActivity {
    public static final String SCORE = "score";
    private int score = 0;
    @BindView(R.id.contentView)
    FrameLayout contentView;
    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getBus().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getBus().register(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initNavigationDrawer();

    }

    @Subscribe
    public void onUpdateUIEventReceived(UpdateUIEvent event) {
        showChart(event.getScheme());
        score = event.getScore();
        navigationView.getMenu().findItem(R.id.opt_submit).setEnabled(true);
    }

    private void initNavigationDrawer() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.opt_defensive:
                        showChart(InvestorTypeScheme.DEFENSIVE);
                        break;
                    case R.id.opt_conservative:
                        showChart(InvestorTypeScheme.CONSERVATIVE);
                        break;
                    case R.id.opt_balanced:
                        showChart(InvestorTypeScheme.BALANCED);
                        break;
                    case R.id.opt_balanced_growth:
                        showChart(InvestorTypeScheme.BALANCED_GROWTH);
                        break;
                    case R.id.opt_growth:
                        showChart(InvestorTypeScheme.GROWTH);
                        break;
                    case R.id.opt_aggressive_growth:
                        showChart(InvestorTypeScheme.AGGRESSIVE_GROWTH);
                        break;
                    case R.id.opt_questionnaire:
                        startQuestionnaire();
                        break;
                    case R.id.opt_submit:
                        submit();
                        break;

                }
                return true;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void submit() {
        SubmissionFragment fragment = new SubmissionFragment();
        Bundle args = new Bundle();
        args.putInt(SCORE, score);
        fragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentView, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
        drawerLayout.closeDrawers();
    }

    private void startQuestionnaire() {
        QuestionnaireFragment fragment = new QuestionnaireFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentView, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
        drawerLayout.closeDrawers();
    }


    private void showChart(int[] picIds) {
        InvestorDetailsFragment fragment = new InvestorDetailsFragment();
        Bundle args = new Bundle();
        args.putIntArray(InvestorDetailsFragment.PIC_IDS, picIds);
        fragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentView, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
        drawerLayout.closeDrawers();
    }

}
