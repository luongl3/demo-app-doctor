package app.doctor.demo_app.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GestureDetectorCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import app.doctor.demo_app.R;
import app.doctor.demo_app.ui.activity.LoginActivity;
import butterknife.BindView;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */

public abstract class BaseActivity<D extends ViewDataBinding> extends AppCompatActivity implements HasSupportFragmentInjector {

    @Nullable
    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;
    protected ActionBar mActionBar;
    private ProgressDialog mProgressDialog;
    private AlertDialog mErrorDialog;
    protected boolean isDisplayedHomeAsUpEnabled = true;

    @Nullable
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentAndroidInjector;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    public D dataBinding;

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentAndroidInjector;
    }

    @Override
    protected void onDestroy() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
        if (mErrorDialog != null) {
            mErrorDialog.dismiss();
            mErrorDialog = null;
        }
        super.onDestroy();
    }

    public void showErrorDialog(String errorMessage, final boolean isRedirectToLoginScreen) {
        if (mErrorDialog == null) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage(errorMessage).setCancelable(false)
                    .setOnCancelListener(DialogInterface::cancel)
                    .setPositiveButton(R.string.close, (dialog1, which) -> {
                    });
            mErrorDialog = dialog.create();
        }

        if (!mErrorDialog.isShowing()) {
            mErrorDialog.setMessage(errorMessage);
            mErrorDialog.show();
        }
    }

    public void showLoadingDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog = ProgressDialog.show(this, null, this.getResources().getString(R.string.processing), true, false);
        } else {
            if (!mProgressDialog.isShowing())
                mProgressDialog.show();
        }
    }

    public void hideLoadingDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }
}

