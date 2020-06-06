package app.doctor.demo_app;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import app.doctor.demo_app.data.local.ChanelDao;
import app.doctor.demo_app.data.remote.ApiService;
import app.doctor.demo_app.data.remote.NetworkBoundResource;
import app.doctor.demo_app.data.remote.Resource;
import app.doctor.demo_app.data.remote.model.ChanelItem;
import app.doctor.demo_app.data.remote.response.PopularChanelResponse;
import retrofit2.Call;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class ChanelRepository {

    private final ChanelDao chanelDao;
    private final ApiService apiService;

    @Inject
    ChanelRepository(ChanelDao dao, ApiService service) {
        this.chanelDao = dao;
        this.apiService = service;
    }

    /**
     * This method fetches the popular articles from the service.
     * Once the fetching is done the data is cached to local db so that the app can even work offline
     *
     * @return List of articles
     */
    public LiveData<Resource<List<ChanelItem>>> loadPopularArticles() {
        return new NetworkBoundResource<List<ChanelItem>, PopularChanelResponse>() {

            @Override
            protected void saveCallResult(PopularChanelResponse item) {
                if (null != item)
                    chanelDao.saveChanelList(item.getPopularArticles());
            }

            @NonNull
            @Override
            protected LiveData<List<ChanelItem>> loadFromDb() {
                return chanelDao.loadChanelList();
            }

            @NonNull
            @Override
            protected Call<PopularChanelResponse> createCall() {
                Map<String, String> param = new HashMap<>();
                param.put("member_idx", "61");
                param.put("page_num", "1");
                param.put("category_idx", "2");
                return apiService.getChanelList(param);
            }
        }.getAsLiveData();
    }


//    /**
//     * This method get chanelDetail
//     */
//    @SuppressLint("CheckResult")
//    public LiveData<Resource<ChanelItem>> loadChanelDetail(int howfarback) {
//        return new NetworkBoundResource<ChanelItem, ChanelItem>() {
//
//            @Override
//            protected void saveCallResult(ChanelItem item) {
//                if (null != item)
//                    chanelDao.saveChanelList(item);
//            }
//
//            @NonNull
//            @Override
//            protected LiveData<ChanelItem> loadFromDb() {
//                return chanelDao.loadChanelDetail();
//            }
//
//            @NonNull
//            @Override
//            protected Call<PopularChanelResponse> createCall() {
//                Map<String, String> param = new HashMap<>();
//                param.put("member_idx", "61");
//                param.put("page_num", "1");
//                param.put("category_idx", "2");
//                return apiService.getChanelDetail(param);
//            }
//        }.getAsLiveData();
//    }
}
