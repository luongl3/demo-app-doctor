package app.doctor.demo_app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import app.doctor.demo_app.data.remote.Resource;
import app.doctor.demo_app.data.remote.model.UserItem;
import app.doctor.demo_app.data.remote.reponsitory.LoginRepository;

/**
 * Created by luonglc on 9/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class LoginViewModel extends ViewModel {
    private String userName;
    private String password;
    private LoginRepository repository;

    @Inject
    public LoginViewModel(LoginRepository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<UserItem>> login() {
        return repository.loginEvent(userName, password);
    }

    public void setUserInfo(String userName, String password) {
        this.password = password;
        this.userName = userName;
    }

}
