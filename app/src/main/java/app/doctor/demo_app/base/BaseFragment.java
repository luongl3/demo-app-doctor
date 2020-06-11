package app.doctor.demo_app.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import app.doctor.demo_app.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<V extends ViewModel, D extends ViewDataBinding> extends Fragment {
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    protected V viewModel;
    protected D dataBinding;

    private ProgressDialog mProgressDialog;
    private AlertDialog mErrorDialog;

    protected View mMainView;
    @BindView(R.id.imgBack)
    protected ImageView mImgBack;
    Unbinder mUnbinder;
    @BindView(R.id.btn_search)
    protected SearchView searchView;
    @BindView(R.id.tv_title)
    protected TextView tvTitle;
    @BindView(R.id.imgSaveOff)
    protected ImageView btnSaveOff;

    protected abstract Class<V> getViewModel();

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        mMainView = inflater.inflate(getLayoutRes(), container, false);
        mUnbinder = ButterKnife.bind(this, dataBinding.getRoot());

        searchView.setBackgroundColor(getResources().getColor(R.color.trans));
        searchView.setOnCloseListener(() -> {
            tvTitle.setVisibility(View.VISIBLE);
            return false;
        });

        return dataBinding.getRoot();
    }

    private void doBack() {
        if (getActivity() != null) getActivity().onBackPressed();
    }


    @Override
    public void onDestroy() {
        mUnbinder.unbind();
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
        if (mErrorDialog != null) {
            mErrorDialog.dismiss();
            mErrorDialog = null;
        }
        super.onDestroy();
        super.onDestroy();
    }

    public void showErrorDialog(String errorMessage, final boolean isRedirectToLoginScreen) {
        if (mErrorDialog == null) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
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

    @OnClick(R.id.imgBack)
    public void backPressed() {
        doBack();
    }

    public void showLoadingDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getContext());
            mProgressDialog = ProgressDialog.show(getContext(), null, this.getResources().getString(R.string.processing),
                    true, false);
        } else {
            if (!mProgressDialog.isShowing())
                mProgressDialog.show();
        }
    }

    public void hideLoadingDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    protected void setTvTitle(String title) {
        tvTitle.setText(title);
    }

    protected void setVisibilityTitle(boolean visibility) {
        tvTitle.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    protected void setVisibilitySearchView(boolean visibility) {
        searchView.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    protected void setVisibilitySaveOff(boolean visibility) {
        btnSaveOff.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    protected void setVisibilityBackButton(boolean visibility) {
        mImgBack.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }
}
