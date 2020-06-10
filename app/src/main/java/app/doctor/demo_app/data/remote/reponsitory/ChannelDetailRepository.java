package app.doctor.demo_app.data.remote.reponsitory;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import app.doctor.demo_app.data.local.ChanelDetailDao;
import app.doctor.demo_app.data.remote.ApiService;
import app.doctor.demo_app.data.remote.NetworkBoundResource;
import app.doctor.demo_app.data.remote.Resource;
import app.doctor.demo_app.data.remote.model.ChannelDetail;
import app.doctor.demo_app.utils.Constants;
import app.doctor.demo_app.utils.Utils;
import retrofit2.Call;

/**
 * Created by luonglc on 8/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class ChannelDetailRepository {
    private ChanelDetailDao chanelDetailDao;
    private ApiService apiService;

    @Inject
    ChannelDetailRepository(ChanelDetailDao dao, ApiService apiService) {
        this.chanelDetailDao = dao;
        this.apiService = apiService;
    }

    /**
     * This method fetches the popular channelDetail from the service.
     * Once the fetching is done the data is cached to local db so that the app can even work offline
     *
     * @return channelDetail
     */
    public LiveData<Resource<ChannelDetail>> loadChannelDetail(@NonNull String boardIdx) {
        return new NetworkBoundResource<ChannelDetail, ChannelDetail>() {

            @Override
            protected void saveCallResult(ChannelDetail item) {
                if (null != item) {
                    chanelDetailDao.saveChannelDetail(item);
                }
            }

            @NonNull
            @Override
            protected LiveData<ChannelDetail> loadFromDb() {
                return chanelDetailDao.loadChannelDetail(boardIdx);
            }

            @NonNull
            @Override
            protected Call<ChannelDetail> createCall() {
                return apiService.getChannelDetail(Utils.getStringValue(Constants.PREF_MEMBER_IDX), boardIdx);
            }
        }.getLiveData();

    }

}
