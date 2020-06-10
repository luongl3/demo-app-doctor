package app.doctor.demo_app.data.remote.reponsitory;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import javax.inject.Inject;

import app.doctor.demo_app.data.local.UserDao;
import app.doctor.demo_app.data.remote.ApiService;
import app.doctor.demo_app.data.remote.NetworkBoundResource;
import app.doctor.demo_app.data.remote.Resource;
import app.doctor.demo_app.data.remote.model.ChannelItem;
import app.doctor.demo_app.data.remote.model.UserItem;
import retrofit2.Call;

/**
 * Created by luonglc on 9/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class LoginRepository {
    private ApiService apiService;
    private UserDao userDao;

    @Inject
    LoginRepository(ApiService apiService, UserDao dao) {
        this.apiService = apiService;
        this.userDao = dao;
    }

    public LiveData<Resource<UserItem>> loginEvent(@NonNull String userName, @NonNull String password) {
        return new NetworkBoundResource<UserItem, UserItem>() {

            @Override
            protected void saveCallResult(UserItem item) {
                if (!TextUtils.isEmpty(item.getMemberId())) {
                    item.setPassword(password);
                    userDao.saveUserInfo(item);
                }
            }

            @NonNull
            @Override
            protected LiveData<UserItem> loadFromDb() {
                return userDao.loadUser(userName, password);
            }

            @NonNull
            @Override
            protected Call<UserItem> createCall() {
                return apiService.login(userName, password, "2", "A");
            }
        }.getLiveData();
    }
}
