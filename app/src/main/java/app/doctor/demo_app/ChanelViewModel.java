package app.doctor.demo_app;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import app.doctor.demo_app.data.remote.Resource;
import app.doctor.demo_app.data.remote.model.ChanelItem;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class ChanelViewModel extends ViewModel {
    private final LiveData<Resource<List<ChanelItem>>> popularArticles;

    @Inject
    public ChanelViewModel(ChanelRepository chanelRepository) {
        popularArticles = chanelRepository.loadPopularArticles();
    }

    public LiveData<Resource<List<ChanelItem>>> getChanelList() {
        return popularArticles;
    }
}
