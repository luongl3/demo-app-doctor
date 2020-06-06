package app.doctor.demo_app.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class BaseResponse {
    @SerializedName("code")
    private String statusCode;
    @SerializedName("code_msg")
    private String statusMsg;
}
