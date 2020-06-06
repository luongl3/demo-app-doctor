package app.doctor.demo_app.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Entity(tableName = "categories")
public class Category {
    @PrimaryKey
    @NonNull
    @SerializedName("category_idx")
    private String categoryIdx;
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("ins_date")
    private String insDate;

    public String getCategoryIdx() {
        return categoryIdx;
    }

    public void setCategoryIdx(String categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getInsDate() {
        return insDate;
    }

    public void setInsDate(String insDate) {
        this.insDate = insDate;
    }
}
