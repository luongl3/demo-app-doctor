package app.doctor.demo_app.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import app.doctor.demo_app.R;
import app.doctor.demo_app.base.BaseFragment;
import app.doctor.demo_app.databinding.ChannelDetailFragmentBinding;
import app.doctor.demo_app.ui.activity.MainActivity;
import app.doctor.demo_app.utils.Constants;
import app.doctor.demo_app.viewmodel.ChannelDetailViewModel;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class ChannelDetailFragment extends BaseFragment<ChannelDetailViewModel, ChannelDetailFragmentBinding> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLoadingDialog();
        if (getActivity() != null)
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        Bundle args = getArguments();
        if (null != args) {
            viewModel.setBoardIdx(args.getString(Constants.PREF_CHANNEL_BOARD_IDX));
            viewModel.getChannelDetail().observe(getViewLifecycleOwner(), resource -> {
                dataBinding.setChannelItem(resource.data);
                if (null != resource.data) {
                    Picasso.get().load(resource.data.imgPath).error(R.drawable.ic_place_holder).into(dataBinding.imgChanel);
                    dataBinding.webContent.loadData(resource.data.contents, "text/html", "UTF-8");
                    dataBinding.webContent.setWebViewClient(new WebViewClient() {
                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            hideLoadingDialog();
                        }
                    });
                }
            });
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView() {

        dataBinding.layoutRoot.setHorizontalScrollBarEnabled(false);
        dataBinding.layoutRoot.setVerticalScrollBarEnabled(false);

        dataBinding.webContent.setWebViewClient(new WebViewClient());
        dataBinding.webContent.getSettings().setJavaScriptEnabled(true);
        dataBinding.webContent.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        dataBinding.webContent.getSettings().setPluginState(WebSettings.PluginState.ON);
        dataBinding.webContent.getSettings().setMediaPlaybackRequiresUserGesture(false);
        dataBinding.webContent.setWebChromeClient(new WebChromeClient());
        dataBinding.webContent.setVerticalScrollBarEnabled(false);
        dataBinding.webContent.setHorizontalScrollBarEnabled(false);
        dataBinding.webContent.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    @Override
    protected Class<ChannelDetailViewModel> getViewModel() {
        return ChannelDetailViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.channel_detail_fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
