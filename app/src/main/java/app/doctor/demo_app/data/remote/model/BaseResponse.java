package app.doctor.demo_app.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class BaseResponse<T> {
    @SerializedName("data_array")
    public List<T> data;

    /**
     * This method return the list of chanelItem entities
     *
     * @return List of entities
     */
    public List<T> getDataResponse() {
        return data;
    }

    /**
     * This method sets the article entities
     *
     * @param data
     */
    @SuppressWarnings("unused")
    public void setDataResponse(List<T> data) {
        this.data = data;
    }
}
