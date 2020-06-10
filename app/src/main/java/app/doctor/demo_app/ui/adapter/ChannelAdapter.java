package app.doctor.demo_app.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import app.doctor.demo_app.R;
import app.doctor.demo_app.base.BaseAdapter;
import app.doctor.demo_app.data.remote.model.ChannelItem;
import app.doctor.demo_app.databinding.ItemChanelBinding;
import app.doctor.demo_app.ui.callback.OnItemClick;

/**
 * Created by luonglc on 6/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class ChannelAdapter extends BaseAdapter<ChannelAdapter.ViewHolder, ChannelItem> implements Filterable {

    private List<ChannelItem> channelItemList;
    private List<ChannelItem> channelItemsFiltered;
    private final OnItemClick callBack;

    public ChannelAdapter(OnItemClick callBack) {
        this.channelItemList = new ArrayList<>();
        this.channelItemsFiltered = new ArrayList<>();
        this.callBack = callBack;
    }

    @Override
    public void setData(List<ChannelItem> data) {
        channelItemList = data;
        channelItemsFiltered = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChannelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolder.create(LayoutInflater.from(parent.getContext()), parent, callBack);
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelAdapter.ViewHolder holder, int position) {
        holder.onBind(channelItemsFiltered.get(position));
        Picasso.get().load(channelItemList.get(position).imgPath).error(R.drawable.ic_place_holder).into(holder.binding.imgChanel);

//        Picasso.with(getActivity())
//                .load(imageUrl)
//                .error(R.drawable.error)
//                .resize(screenWidth, imageHeight)
//                .centerInside()
//                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return channelItemsFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    channelItemsFiltered = channelItemList;
                } else {
                    List<ChannelItem> filteredList = new ArrayList<>();
                    for (ChannelItem row : channelItemList) {

                        // name match condition. this might differ depending on your requirement
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())
                                || row.getTitle().toLowerCase().contains(charString.toLowerCase())
                                || row.getCategory().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    channelItemsFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = channelItemsFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                channelItemsFiltered = (ArrayList<ChannelItem>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public static ViewHolder create(LayoutInflater inflater, ViewGroup parent, OnItemClick callback) {
            ItemChanelBinding itemChanelBinding = ItemChanelBinding.inflate(inflater, parent, false);
            return new ViewHolder(itemChanelBinding, callback);
        }

        final ItemChanelBinding binding;

        private ViewHolder(ItemChanelBinding binding, OnItemClick callback) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(v ->
                    callback.onChannelClicked(binding.getChannelItem()));
        }

        private void onBind(ChannelItem articleEntity) {
            binding.setChannelItem(articleEntity);
            binding.executePendingBindings();
        }
    }
}
