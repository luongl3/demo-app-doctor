package app.doctor.demo_app;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import app.doctor.demo_app.data.local.DemoAppDatabase;
import app.doctor.demo_app.data.remote.model.ChannelDetail;
import app.doctor.demo_app.data.remote.model.UserItem;

import static org.junit.Assert.assertNotNull;

/**
 * Created by luonglc on 10/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@RunWith(AndroidJUnit4.class)
public class UserDaoTest {
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
    public void testLoadUser() {
        UserItem entity = new UserItem();
        entity.setMemberIdx("143");
        entity.setMemberId("ttt@gmail.com");
        entity.setPassword("12122012gv!");
        database.userDao().saveUserInfo(entity);
        LiveData<UserItem> data = database.userDao().loadUser("17", "12122012gv!");
        assertNotNull(data);
    }
}
