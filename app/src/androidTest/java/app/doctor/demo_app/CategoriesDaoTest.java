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
import app.doctor.demo_app.data.remote.model.CategoryItem;
import app.doctor.demo_app.data.remote.model.ChannelItem;

import static org.junit.Assert.assertNotNull;

/**
 * Created by luonglc on 10/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@RunWith(AndroidJUnit4.class)
public class CategoriesDaoTest {
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
        List<CategoryItem> list = new ArrayList<>();
        CategoryItem entity = new CategoryItem();
        entity.setCategoryIdx("1");
        entity.setCategoryName("오늘뭐먹지");
        entity.setInsDate("2020-04-23 10:59:26");
        list.add(entity);
        database.categoryDao().saveCategories(list);
        LiveData<List<ChannelItem>> chanelListWithCategory = database.chanelDao().loadChanelListWithCategory("1");
        assertNotNull(chanelListWithCategory);
    }

}
