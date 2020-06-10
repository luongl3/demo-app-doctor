package app.doctor.demo_app.data.remote.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by luonglc on 7/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Entity(tableName = "categories")
public class CategoryItem {
    @PrimaryKey
    @NonNull
    @SerializedName("category_idx")
    public String categoryIdx;

    @SerializedName("category_name")
    public String categoryName;

    @SerializedName("ins_date")
    public String insDate;

    public String getCategoryIdx() {
        return categoryIdx;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getInsDate() {
        return insDate;
    }

    public void setCategoryIdx(@NonNull String categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setInsDate(String insDate) {
        this.insDate = insDate;
    }
}
