package app.doctor.demo_app.data.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import app.doctor.demo_app.data.remote.model.ChanelItem;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class PopularChanelResponse {
    @SerializedName("results")
    private List<ChanelItem> chanelItems;

    /**
     * This method return the list of chanelItem entities
     *
     * @return List of entities
     */
    public List<ChanelItem> getPopularArticles() {
        return chanelItems;
    }

    /**
     * This method sets the article entities
     *
     * @param chanelItems - chanelItems
     */
    @SuppressWarnings("unused")
    public void setPopularArticles(List<ChanelItem> chanelItems) {
        this.chanelItems = chanelItems;
    }
}
