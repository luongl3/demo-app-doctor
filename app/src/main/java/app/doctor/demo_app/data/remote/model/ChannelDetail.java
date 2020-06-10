package app.doctor.demo_app.data.remote.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


/**
 * Created by luonglc on 6/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Entity(tableName = "channelDetail")
public class ChannelDetail {
    @PrimaryKey
    @NonNull
    @SerializedName("board_idx")
    public String boardIdx;

    @Nullable
    @SerializedName("category_idx")
    public String categoryIdx;

    @SerializedName("board_type")
    public String boarType;

    @SerializedName("ins_date")
    public String insDate;

    @SerializedName("title")
    public String title;

    @SerializedName("board_img")
    public String imgPath;

    @SerializedName("reply_cnt")
    public String replyCnt;

    @SerializedName("like_cnt")
    public String likeCnt;

    @SerializedName("my_like_yn")
    public String myLikeYn;

    @SerializedName("category")
    public String category;

    @SerializedName("contents_yn")
    public String contentsYn;

    @SerializedName("corp_idx")
    public String corpIdx;

    @SerializedName("contents")
    public String contents;

    @NonNull
    public String getBoardIdx() {
        return boardIdx;
    }

    public String getBoarType() {
        return boarType;
    }

    public String getInsDate() {
        return insDate;
    }

    public String getTitle() {
        return title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getReplyCnt() {
        return replyCnt;
    }

    public String getLikeCnt() {
        return likeCnt;
    }

    public String getMyLikeYn() {
        return myLikeYn;
    }

    public String getCategory() {
        return category;
    }

    public String getContentsYn() {
        return contentsYn;
    }

    @Nullable
    public String getCategoryIdx() {
        return categoryIdx;
    }

    public void setCategoryIdx(@Nullable String categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setBoardIdx(@NonNull String boardIdx) {
        this.boardIdx = boardIdx;
    }

    public void setBoarType(String boarType) {
        this.boarType = boarType;
    }

    public void setInsDate(String insDate) {
        this.insDate = insDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setReplyCnt(String replyCnt) {
        this.replyCnt = replyCnt;
    }

    public void setLikeCnt(String likeCnt) {
        this.likeCnt = likeCnt;
    }

    public void setMyLikeYn(String myLikeYn) {
        this.myLikeYn = myLikeYn;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setContentsYn(String contentsYn) {
        this.contentsYn = contentsYn;
    }

    public void setCorpIdx(String corpIdx) {
        this.corpIdx = corpIdx;
    }
}
