package app.doctor.demo_app.ui.callback;

import app.doctor.demo_app.data.remote.model.CategoryItem;
import app.doctor.demo_app.data.remote.model.ChannelItem;

/**
 * Created by luonglc on 7/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public interface OnItemClick {
    void categoryOnClick(CategoryItem categoryItem);

    void onChannelClicked(ChannelItem channelItem);
}
