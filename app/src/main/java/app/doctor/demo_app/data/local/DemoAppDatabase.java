package app.doctor.demo_app.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import app.doctor.demo_app.data.remote.model.CategoryItem;
import app.doctor.demo_app.data.remote.model.ChannelDetail;
import app.doctor.demo_app.data.remote.model.ChannelItem;
import app.doctor.demo_app.data.remote.model.UserItem;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Database(entities = {ChannelItem.class, CategoryItem.class, ChannelDetail.class, UserItem.class}, version = 1)
public abstract class DemoAppDatabase extends RoomDatabase {
    public abstract ChanelDao chanelDao();

    public abstract CategoryDao categoryDao();

    public abstract ChanelDetailDao chanelDetailDao();

    public abstract UserDao userDao();
}
