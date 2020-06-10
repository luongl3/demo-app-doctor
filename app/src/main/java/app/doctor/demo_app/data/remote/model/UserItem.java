package app.doctor.demo_app.data.remote.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import app.doctor.demo_app.base.BaseResponse;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Entity(tableName = "user")
public class UserItem  {
    @SerializedName("member_id")
    private String memberId;

    @PrimaryKey
    @NonNull
    @SerializedName("member_idx")
    private String memberIdx;

    @SerializedName("member_name")
    private String memberName;

    @SerializedName("password")
    private String password;

    @SerializedName("code_msg")
    private String msg;

    public String getMemberId() {
        return memberId;
    }

    public UserItem() {
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberIdx() {
        return memberIdx;
    }

    public void setMemberIdx(@NonNull String memberIdx) {
        this.memberIdx = memberIdx;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
