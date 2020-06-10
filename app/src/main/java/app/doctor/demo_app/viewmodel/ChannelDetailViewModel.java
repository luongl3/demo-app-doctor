package app.doctor.demo_app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import app.doctor.demo_app.data.remote.Resource;
import app.doctor.demo_app.data.remote.model.ChannelDetail;
import app.doctor.demo_app.data.remote.reponsitory.ChannelDetailRepository;

/**
 * Created by luonglc on 8/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class ChannelDetailViewModel extends ViewModel {
    private String boardIdx;
    private ChannelDetailRepository repository;

    @Inject
    ChannelDetailViewModel(ChannelDetailRepository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<ChannelDetail>> getChannelDetail() {
        return repository.loadChannelDetail(getBoardIdx());
    }

    public String getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(String boardIdx) {
        this.boardIdx = boardIdx;
    }

}
