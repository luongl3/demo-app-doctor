package app.doctor.demo_app.data.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class LoginResponse {
    @SerializedName("member_id")
    private String memberId;

    @SerializedName("member_idx")
    private String memberIdx;

    @SerializedName("member_name")
    private String memberName;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberIdx() {
        return memberIdx;
    }

    public void setMemberIdx(String memberIdx) {
        this.memberIdx = memberIdx;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
