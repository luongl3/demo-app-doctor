package app.doctor.demo_app;

import androidx.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public interface BaseSchedulerProvider  {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}