package app.doctor.demo_app.data.remote;

import app.doctor.demo_app.data.remote.model.CategoryItem;
import app.doctor.demo_app.data.remote.model.ChannelDetail;
import app.doctor.demo_app.data.remote.model.ChannelItem;
import app.doctor.demo_app.data.remote.model.UserItem;
import app.doctor.demo_app.data.remote.model.BaseResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("/login_v_1_0_0/member_login?")
    Call<UserItem> login(@Field("member_id") String memberId,
                         @Field("member_pw") String memberPw,
                         @Field("gcm_key") String gcmKey,
                         @Field("device_os") String deviceOS);

    @FormUrlEncoded
    @POST("/board_v_1_0_0/channel_list?")
    Call<BaseResponse<ChannelItem>> getChannelList(@Field("member_idx") String memberIdx,
                                                   @Field("page_num") String pageNum,
                                                   @Field("category_idx") String categoryIdx);

    @POST("/board_v_1_0_0/channel_category_list")
    Call<BaseResponse<CategoryItem>> getCategories();

    @FormUrlEncoded
    @POST("board_v_1_0_0/channel_detail?")
    Call<ChannelDetail> getChannelDetail(@Field("member_idx") String memberIdx,
                                         @Field("board_idx") String boardIdx);
}
