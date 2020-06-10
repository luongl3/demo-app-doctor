package app.doctor.demo_app.ui.activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import app.doctor.demo_app.ui.callback.NavigationViewCallBack;
import app.doctor.demo_app.utils.FragmentUtils;
import app.doctor.demo_app.R;
import app.doctor.demo_app.base.BaseActivity;
import app.doctor.demo_app.databinding.MainActivityBinding;
import app.doctor.demo_app.ui.fragment.HomeFragment;

/**
 * Created by luonglc on 6/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class  MainActivity extends BaseActivity<MainActivityBinding> implements NavigationViewCallBack {

    @Override
    public int getLayoutRes() {
        return R.layout.main_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeFragment fragment = new HomeFragment();
        fragment.setNavigationCallBack(this);
        FragmentUtils.replaceFragment(this, fragment, R.id.fragContainer,
                true, FragmentUtils.TRANSITION_POP);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onFinish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onFinish();
    }

    private void onFinish() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragContainer);
        if (currentFragment == null) {
            this.finish();
        }
    }

    @Override
    public void onShowNavigationBottomBar() {
        dataBinding.navView.animate().translationY(0);
    }

    @Override
    public void onHideNavigationBottomBar() {
        dataBinding.navView.animate().translationY(dataBinding.navView.getHeight());
    }
}
