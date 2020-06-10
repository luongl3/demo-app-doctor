package app.doctor.demo_app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import app.doctor.demo_app.data.remote.ApiConstants;
import app.doctor.demo_app.data.remote.ApiService;
import app.doctor.demo_app.utils.Constants;
import app.doctor.demo_app.utils.Utils;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by luonglc on 10/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@RunWith(JUnit4.class)
public class ApiServiceUnitTest {

    private ApiService apiService;

    @Before
    public void createService() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS);

        apiService = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build()
                .create(ApiService.class);
    }

    @Test
    public void login() {
        try {
            Response response = apiService.login("ttt@gmail.com", "12122012gv!", "2", "A").execute();
            assertEquals(response.code(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCategory() {
        try {
            Response response = apiService.getCategories().execute();
            assertEquals(response.code(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getChannelList() {
        try {
            Response response = apiService.getChannelList(Utils.getStringValue(Constants.PREF_MEMBER_IDX), "1", "1").execute();
            assertEquals(response.code(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getChannelDetail() {
        try {
            Response response = apiService.getChannelDetail(Utils.getStringValue(Constants.PREF_MEMBER_IDX), "17").execute();
            assertEquals(response.code(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
