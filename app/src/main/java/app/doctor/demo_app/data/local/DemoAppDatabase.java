package app.doctor.demo_app.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import app.doctor.demo_app.data.remote.model.ChanelItem;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Database(entities = {ChanelItem.class}, version = 1)
public abstract class DemoAppDatabase extends RoomDatabase {
    public abstract ChanelDao chanelDao();

    public abstract CategoryDao categoryDao();
}
