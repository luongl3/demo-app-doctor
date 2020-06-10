package app.doctor.demo_app.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import app.doctor.demo_app.data.remote.model.ChannelItem;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Dao
public interface ChanelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveChannelList(List<ChannelItem> channelItemList);

    @Query("SELECT * FROM ChannelItem WHERE categoryIdx = :categoryIdx")
    LiveData<List<ChannelItem>> loadChanelListWithCategory(String categoryIdx);
}
