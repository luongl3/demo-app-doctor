package app.doctor.demo_app.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;

import app.doctor.demo_app.FragmentUtils;
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
public class MainActivity extends BaseActivity<MainActivityBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.main_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtils.replaceFragment(this, HomeFragment.newInstance(), R.id.fragContainer, false, 0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
