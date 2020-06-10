package app.doctor.demo_app.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import app.doctor.demo_app.R;
import app.doctor.demo_app.base.BaseActivity;
import app.doctor.demo_app.databinding.LoginActivityBinding;
import app.doctor.demo_app.utils.Constants;
import app.doctor.demo_app.utils.Utils;
import app.doctor.demo_app.viewmodel.LoginViewModel;

/**
 * Created by luonglc on 7/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class LoginActivity extends BaseActivity<LoginActivityBinding> implements View.OnClickListener {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private LoginViewModel viewModel;
    private boolean isGoMain = true;

    @Override
    public int getLayoutRes() {
        return R.layout.login_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));

        dataBinding.btnLogin.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        isGoMain = true;
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == dataBinding.btnLogin.getId()) {
            showLoadingDialog();
            viewModel.setUserInfo(dataBinding.editUserName.getText().toString().trim(), dataBinding.editPassword.getText().toString().trim());
            viewModel.login().observe(this, resource -> {
                if (resource.data != null && !TextUtils.isEmpty(resource.data.getMemberId()) && isGoMain) {
                    Utils.savePreference(Constants.PREF_MEMBER_IDX, resource.data.getMemberIdx());
                    gotoMainActivity();
                }
            });
        }
    }

    private void gotoMainActivity() {
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            isGoMain = false;
            finish();
        }, 500);
    }


}
