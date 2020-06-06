package app.doctor.demo_app.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import app.doctor.demo_app.ChanelViewModel;
import app.doctor.demo_app.R;
import app.doctor.demo_app.base.BaseFragment;
import app.doctor.demo_app.data.remote.Status;
import app.doctor.demo_app.data.remote.model.ChanelItem;
import app.doctor.demo_app.databinding.FragmentHomeBinding;
import app.doctor.demo_app.ui.callback.CategoryCallBack;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class HomeFragment extends BaseFragment<ChanelViewModel, FragmentHomeBinding>
        implements CategoryCallBack {

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);
        dataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        dataBinding.recyclerView.setAdapter(new ArticleListAdapter(this));
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel.getChanelList()
                .observe(getViewLifecycleOwner(), listResource -> {
                    if (null != listResource && (listResource.status == Status.ERROR || listResource.status == Status.SUCCESS)) {
                        dataBinding.loginProgress.setVisibility(View.GONE);
                    }
                    dataBinding.setResource(listResource);
                    if (null != dataBinding.recyclerView.getAdapter() && dataBinding.recyclerView.getAdapter().getItemCount() > 0) {
                        dataBinding.errorText.setVisibility(View.GONE);
                    }
                });

    }


    @Override
    public void onChanelClicked(ChanelItem chanelItem) {

    }

    @Override
    protected Class<ChanelViewModel> getViewModel() {
        return ChanelViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }
}
