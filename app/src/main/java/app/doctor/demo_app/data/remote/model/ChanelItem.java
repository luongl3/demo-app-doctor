package app.doctor.demo_app.data.remote.model;

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
@Entity(tableName = "chanelItem")
public class ChanelItem {
    @PrimaryKey
    @NonNull
    @SerializedName("board_idx")
    private String boarIdx;

    @SerializedName("board_type")
    private String boarType;

    @SerializedName("ins_date")
    private String insDate;

    @SerializedName("title")
    private String title;

    @SerializedName("img_path")
    private String imgPath;

    @SerializedName("reply_cnt")
    private String replyCnt;

    @SerializedName("like_cnt")
    private String likeCnt;

    @SerializedName("my_like_yn")
    private String myLikeYn;

    @SerializedName("category")
    private String category;

    @SerializedName("contents_yn")
    private String contentsYn;

    public String getBoarIdx() {
        return boarIdx;
    }

    public void setBoarIdx(String boarIdx) {
        this.boarIdx = boarIdx;
    }

    public String getBoarType() {
        return boarType;
    }

    public void setBoarType(String boarType) {
        this.boarType = boarType;
    }

    public String getInsDate() {
        return insDate;
    }

    public void setInsDate(String insDate) {
        this.insDate = insDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getReplyCnt() {
        return replyCnt;
    }

    public void setReplyCnt(String replyCnt) {
        this.replyCnt = replyCnt;
    }

    public String getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(String likeCnt) {
        this.likeCnt = likeCnt;
    }

    public String getMyLikeYn() {
        return myLikeYn;
    }

    public void setMyLikeYn(String myLikeYn) {
        this.myLikeYn = myLikeYn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContentsYn() {
        return contentsYn;
    }

    public void setContentsYn(String contentsYn) {
        this.contentsYn = contentsYn;
    }
}
