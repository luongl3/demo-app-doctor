package app.doctor.demo_app;

import app.doctor.demo_app.data.remote.model.ChanelItem;

/**
 * Created by luonglc on 6/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public interface ResponseListener {
    void onSuccess(ChanelItem data);
    void onFailure(String message);
}
