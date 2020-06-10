package app.doctor.demo_app.data.remote.reponsitory;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import app.doctor.demo_app.data.local.CategoryDao;
import app.doctor.demo_app.data.local.ChanelDao;
import app.doctor.demo_app.data.remote.ApiService;
import app.doctor.demo_app.data.remote.NetworkBoundResource;
import app.doctor.demo_app.data.remote.Resource;
import app.doctor.demo_app.data.remote.model.BaseResponse;
import app.doctor.demo_app.data.remote.model.CategoryItem;
import app.doctor.demo_app.data.remote.model.ChannelItem;
import app.doctor.demo_app.utils.Constants;
import app.doctor.demo_app.utils.Utils;
import retrofit2.Call;

/**
 * Created by luonglc on 7/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class HomeRepository {
    private ChanelDao chanelDao;
    private CategoryDao categoryDao;
    private ApiService apiService;


    @Inject
    HomeRepository(ChanelDao dao, ApiService service, CategoryDao categoryDao) {
        this.chanelDao = dao;
        this.apiService = service;
        this.categoryDao = categoryDao;
    }

    /**
     * This method fetches the popular channelList from the service.
     * Once the fetching is done the data is cached to local db so that the app can even work offline
     *
     * @return List of channel
     */
    public LiveData<Resource<List<ChannelItem>>> loadChannelList(String categoryIdx) {
        return new NetworkBoundResource<List<ChannelItem>, BaseResponse<ChannelItem>>() {

            @Override
            protected void saveCallResult(BaseResponse<ChannelItem> item) {
                if (item != null) {
                    for (ChannelItem channelItem : item.getDataResponse()) {
                        channelItem.categoryIdx = categoryIdx;
                    }
                    chanelDao.saveChannelList(item.getDataResponse());
                }
            }

            @NonNull
            @Override
            protected LiveData<List<ChannelItem>> loadFromDb() {
                return chanelDao.loadChanelListWithCategory(categoryIdx);
            }

            @NonNull
            @Override
            protected Call<BaseResponse<ChannelItem>> createCall() {
                return apiService.getChannelList(categoryIdx, "1", categoryIdx);
            }
        }.getLiveData();

    }

    /**
     * This method fetches the popular categories from the service.
     * Once the fetching is done the data is cached to local db so that the app can even work offline
     *
     * @return List of category
     */
    public LiveData<Resource<List<CategoryItem>>> loadCategories() {
        return new NetworkBoundResource<List<CategoryItem>, BaseResponse<CategoryItem>>() {

            @Override
            protected void saveCallResult(BaseResponse<CategoryItem> item) {
                if (null != item)
                    categoryDao.saveCategories(item.getDataResponse());
            }

            @NonNull
            @Override
            protected LiveData<List<CategoryItem>> loadFromDb() {
                return categoryDao.loadCategories();
            }

            @NonNull
            @Override
            protected Call<BaseResponse<CategoryItem>> createCall() {
                return apiService.getCategories();
            }
        }.getLiveData();
    }
}
