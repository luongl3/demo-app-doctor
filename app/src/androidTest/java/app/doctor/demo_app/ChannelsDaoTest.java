package app.doctor.demo_app;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import app.doctor.demo_app.data.local.DemoAppDatabase;
import app.doctor.demo_app.data.remote.model.ChannelItem;

import static org.junit.Assert.assertNotNull;

/**
 * Created by luonglc on 10/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@RunWith(AndroidJUnit4.class)
public class ChannelsDaoTest {
    private DemoAppDatabase database;

    @Before
    public void init() {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), DemoAppDatabase.class).build();
    }

    @After
    public void unit() {
        database.close();
    }

    @Test
    public void testLoadChannelList() {
        List<ChannelItem> list = new ArrayList<>();
        ChannelItem entity = new ChannelItem();
        entity.setCategoryIdx("1");
        entity.setCategory("오늘뭐먹지");
        entity.setBoarIdx("17");
        entity.setBoarType("board");
        entity.setInsDate("2020.05.05");
        entity.setContentsYn("Y");
        entity.setMyLikeYn("N");
        entity.setLikeCnt("0");
        entity.setTitle("5월 제철식재료 딸기");
        entity.setImgPath("http://dev-admin.martjangbogo.com/media/commonfile/202005/08/f891bab61fabf768e98b6d1f95ab7d41.png");
        list.add(entity);
        database.chanelDao().saveChannelList(list);
        LiveData<List<ChannelItem>> chanelListWithCategory = database.chanelDao().loadChanelListWithCategory("1");
        assertNotNull(chanelListWithCategory);
    }

}
