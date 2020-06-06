package app.doctor.demo_app.di.components;

import android.app.Application;

import javax.inject.Singleton;

import app.doctor.demo_app.DemoApp;
import app.doctor.demo_app.di.builder.ActivityBuilderModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by luonglc on 6/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(DemoApp demoApp);
}
