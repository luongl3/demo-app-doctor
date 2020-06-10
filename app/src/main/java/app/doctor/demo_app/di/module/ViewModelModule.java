package app.doctor.demo_app.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import app.doctor.demo_app.data.remote.model.ChannelDetail;
import app.doctor.demo_app.viewmodel.ChannelDetailViewModel;
import app.doctor.demo_app.viewmodel.HomeViewModel;
import app.doctor.demo_app.viewmodel.LoginViewModel;
import app.doctor.demo_app.viewmodel.ViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsChanelListViewModel(HomeViewModel homeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ChannelDetailViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsChanelDetailViewModel(ChannelDetailViewModel channelDetailViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
