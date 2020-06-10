package app.doctor.demo_app.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import app.doctor.demo_app.data.remote.model.ChannelDetail;
import app.doctor.demo_app.data.remote.model.ChannelItem;

/**
 * Created by luonglc on 6/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Dao
public interface ChanelDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveChannelDetail(ChannelDetail item);

    @Query("SELECT * FROM channelDetail WHERE boardIdx = :boardIdx")
    LiveData<ChannelDetail> loadChannelDetail(String boardIdx);
}
