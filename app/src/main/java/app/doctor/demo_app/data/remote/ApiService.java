package app.doctor.demo_app.data.remote;

import java.util.Map;

import app.doctor.demo_app.data.remote.model.ChanelItem;
import app.doctor.demo_app.data.remote.model.LoginResponse;
import app.doctor.demo_app.data.remote.response.PopularChanelResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public interface ApiService {

    @POST("login_v_1_0_0/member_login?")
    Call<LoginResponse> login(@Body Map<String, String> param);

    @POST("/board_v_1_0_0/channel_list?")
    Call<PopularChanelResponse> getChanelList(@Body Map<String, String> param);

    @POST("/board_v_1_0_0/channel_list?")
    Call<ChanelItem> getChanelDetail(@Body Map<String, String> param);
}
