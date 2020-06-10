package app.doctor.demo_app.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import app.doctor.demo_app.data.remote.model.CategoryItem;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Dao
public interface CategoryDao {

    @Query("SELECT * FROM categories")
    LiveData<List<CategoryItem>> loadCategories();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveCategories(List<CategoryItem> categories);
}
