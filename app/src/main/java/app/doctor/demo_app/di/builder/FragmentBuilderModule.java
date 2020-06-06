package app.doctor.demo_app.di.builder;
import app.doctor.demo_app.ui.fragment.HomeFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@Module
public abstract class FragmentBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract HomeFragment contributeArticleListFragment();
}