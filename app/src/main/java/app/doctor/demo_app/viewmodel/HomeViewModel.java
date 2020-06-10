package app.doctor.demo_app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import app.doctor.demo_app.data.remote.Resource;
import app.doctor.demo_app.data.remote.model.CategoryItem;
import app.doctor.demo_app.data.remote.model.ChannelItem;
import app.doctor.demo_app.data.remote.reponsitory.HomeRepository;
import app.doctor.demo_app.utils.Constants;
import app.doctor.demo_app.utils.Utils;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class HomeViewModel extends ViewModel {
    private LiveData<Resource<List<ChannelItem>>> channelList;
    private LiveData<Resource<List<CategoryItem>>> categories;
    private String categoryIdx;
    private HomeRepository homeRepository;

    @Inject
    HomeViewModel(HomeRepository chanelRepository) {
        this.homeRepository = chanelRepository;
    }

    public LiveData<Resource<List<ChannelItem>>> getChannels() {

        return homeRepository.loadChannelList(categoryIdx);
    }

    public LiveData<Resource<List<CategoryItem>>> getCategories() {
        return homeRepository.loadCategories();
    }

    public String getCategoryIdx() {
        return categoryIdx;
    }

    public void setCategoryIdx(String categoryIdx) {
        this.categoryIdx = categoryIdx;
    }
}
