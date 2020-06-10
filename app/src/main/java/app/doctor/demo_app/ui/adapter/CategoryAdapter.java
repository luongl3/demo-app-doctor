package app.doctor.demo_app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.doctor.demo_app.R;
import app.doctor.demo_app.base.BaseAdapter;
import app.doctor.demo_app.data.remote.model.CategoryItem;
import app.doctor.demo_app.databinding.CategoryItemBinding;
import app.doctor.demo_app.ui.callback.OnItemClick;

/**
 * Created by luonglc on 7/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class CategoryAdapter extends BaseAdapter<CategoryAdapter.ViewHolder, CategoryItem> {

    private List<CategoryItem> categoryItemList;
    private OnItemClick callBack;
    private static Context mContext;
    private int currentPosition = 0;
    private int prePos = 0;
    private boolean isFirst = true;

    public CategoryAdapter(OnItemClick callBack, Context mContext) {
        this.categoryItemList = new ArrayList<>();
        this.callBack = callBack;
        this.mContext = mContext;
    }

    @Override
    public void setData(List<CategoryItem> data) {
        this.categoryItemList = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolder.create(LayoutInflater.from(parent.getContext()), parent, callBack);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        holder.onBind(categoryItemList.get(position));

        if (position != currentPosition) {
            holder.binding.tvCategoryName.setTextColor(mContext.getResources().getColor(R.color.black));
        } else
            holder.binding.tvCategoryName.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));

        holder.binding.getRoot().setOnClickListener(v -> {
            callBack.categoryOnClick(holder.binding.getCategory());
            prePos = currentPosition;
            currentPosition = position;
            callBack.categoryOnClick(holder.binding.getCategory());
            notifyItemChanged(currentPosition);
            notifyItemChanged(prePos);
        });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public static CategoryAdapter.ViewHolder create(LayoutInflater inflater, ViewGroup parent, OnItemClick callback) {
            CategoryItemBinding itemChanelBinding = CategoryItemBinding.inflate(inflater, parent, false);
            return new CategoryAdapter.ViewHolder(itemChanelBinding, callback);
        }

        final CategoryItemBinding binding;

        private ViewHolder(CategoryItemBinding binding, OnItemClick callback) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void onBind(CategoryItem categoryItem) {
            binding.setCategory(categoryItem);
            binding.executePendingBindings();
        }
    }
}
