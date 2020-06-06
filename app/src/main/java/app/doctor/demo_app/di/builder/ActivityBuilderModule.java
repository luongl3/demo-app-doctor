package app.doctor.demo_app.di.builder;

import app.doctor.demo_app.ui.activity.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Module
public abstract class ActivityBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity mainActivity();
}