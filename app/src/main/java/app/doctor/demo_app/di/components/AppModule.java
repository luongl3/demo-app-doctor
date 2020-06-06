package app.doctor.demo_app.di.components;

import android.app.Application;

import androidx.room.Room;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import app.doctor.demo_app.data.local.ChanelDao;
import app.doctor.demo_app.data.local.DemoAppDatabase;
import app.doctor.demo_app.data.remote.ApiConstants;
import app.doctor.demo_app.data.remote.ApiService;
import app.doctor.demo_app.di.module.ViewModelModule;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luonglc on 6/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    ApiService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    DemoAppDatabase provideArticleDatabase(Application application) {
        return Room.databaseBuilder(application, DemoAppDatabase.class, "articles.db").build();
    }

    @Provides
    @Singleton
    ChanelDao provideArticleDao(DemoAppDatabase articleDatabase) {
        return articleDatabase.chanelDao();
    }

}
