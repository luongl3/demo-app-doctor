package app.doctor.demo_app.ui.fragment;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import app.doctor.demo_app.data.remote.model.CategoryItem;
import app.doctor.demo_app.data.remote.model.ChannelItem;
import app.doctor.demo_app.ui.adapter.CategoryAdapter;
import app.doctor.demo_app.ui.callback.NavigationViewCallBack;
import app.doctor.demo_app.ui.callback.OnItemClick;
import app.doctor.demo_app.utils.Constants;
import app.doctor.demo_app.utils.FragmentUtils;
import app.doctor.demo_app.viewmodel.HomeViewModel;
import app.doctor.demo_app.R;
import app.doctor.demo_app.base.BaseFragment;
import app.doctor.demo_app.data.remote.Status;
import app.doctor.demo_app.databinding.FragmentHomeBinding;
import app.doctor.demo_app.ui.adapter.ChannelAdapter;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class HomeFragment extends BaseFragment<HomeViewModel, FragmentHomeBinding>
        implements OnItemClick {

    private NavigationViewCallBack callBack;

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
        dataBinding.recyclerView.setAdapter(new ChannelAdapter(this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        dataBinding.rcvCategories.setLayoutManager(layoutManager);
        dataBinding.rcvCategories.setAdapter(new CategoryAdapter(this, getContext()));

        return dataBinding.getRoot();
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        callApi();
        initSearchView();
    }

    private void callApi() {
        setVisibilitySaveOff(false);
        setVisibilitySearchView(true);
        setVisibilityBackButton(false);
        setTvTitle("장보고 채널");
        viewModel.getCategories().observe(getViewLifecycleOwner(), listResource -> {
            dataBinding.setCategories(listResource);
            if (listResource.data != null && listResource.data.size() > 0) {
                viewModel.setCategoryIdx(listResource.data.get(0).getCategoryIdx());
                viewModel.getChannels()
                        .observe(this, resource -> {
                            if (null != resource && (resource.status == Status.ERROR || resource.status == Status.SUCCESS)) {
                                hideLoadingDialog();
                            }
                            dataBinding.setResource(resource);
                        });
            }
        });
    }

    private void initSearchView() {
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                if (null != dataBinding.recyclerView.getAdapter())
                    ((ChannelAdapter) dataBinding.recyclerView.getAdapter()).getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                if (null != dataBinding.recyclerView.getAdapter())
                    ((ChannelAdapter) dataBinding.recyclerView.getAdapter()).getFilter().filter(query);
                return false;
            }
        });
    }


    @Override
    protected Class<HomeViewModel> getViewModel() {
        return HomeViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void categoryOnClick(CategoryItem categoryItem) {
        showLoadingDialog();
        viewModel.setCategoryIdx(categoryItem.categoryIdx);
        viewModel.getChannels()
                .observe(getViewLifecycleOwner(), resource -> {
                    if (null != resource && (resource.status == Status.ERROR || resource.status == Status.SUCCESS)) {
                        hideLoadingDialog();
                    }
                    dataBinding.setResource(resource);
                });

    }

    @Override
    public void onChannelClicked(ChannelItem channelItem) {
        if (null != getActivity()) {
            showLoadingDialog();
            Bundle args = new Bundle();
            args.putString(Constants.PREF_CHANNEL_BOARD_IDX, channelItem.getBoarIdx());
            ChannelDetailFragment detailFragment = new ChannelDetailFragment();
            detailFragment.setArguments(args);
            FragmentUtils.replaceFragment((AppCompatActivity) getActivity(), detailFragment,
                    R.id.fragContainer, true, FragmentUtils.TRANSITION_SLIDE_LEFT_RIGHT);
            callBack.onHideNavigationBottomBar();
        }
    }

    public void setNavigationCallBack(NavigationViewCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onResume() {
        super.onResume();
        callBack.onShowNavigationBottomBar();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hideLoadingDialog();
    }
}
