package app.doctor.demo_app.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import app.doctor.demo_app.data.remote.model.ChanelDetail;
import app.doctor.demo_app.data.remote.model.ChanelItem;

/**
 * Created by luonglc on 6/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public interface ChanelDetailDao {

    @Query("SELECT * FROM chanelDetail")
    LiveData<ChanelDetail> loadChanelDetail();
}
