package com.zhafa467.boosterdemo.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.zhafa467.boosterdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends Activity {

    @BindView(R.id.btnWelcome)
    Button btnWelcome;

    @OnClick(R.id.btnWelcome)
    public void onWelcomeButtonClick() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        animateWelcomeButton();
    }

    private void animateWelcomeButton() {
        btnWelcome.setAlpha(0);
        btnWelcome.animate().alpha(1).setDuration(3000).setStartDelay(0);
    }
}
