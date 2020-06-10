package app.doctor.demo_app.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import app.doctor.demo_app.data.remote.model.UserItem;

/**
 * Created by luonglc on 10/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE memberId = :memberId AND password=:password")
    LiveData<UserItem> loadUser(String memberId, String password);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveUserInfo(UserItem userItem);
}
