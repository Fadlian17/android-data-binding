package com.alfansyah.multidaya.androidbinding.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alfansyah.multidaya.androidbinding.R;
import com.alfansyah.multidaya.androidbinding.databinding.ItemPostBinding;
import com.alfansyah.multidaya.androidbinding.models.DataPost;
import com.alfansyah.multidaya.androidbinding.viewmodel.DetailPostViewModel;
import com.alfansyah.multidaya.androidbinding.viewmodel.factories.DetailPostViewModelFactory;
import java.util.ArrayList;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private ArrayList<DataPost> posts = new ArrayList<>();

    public interface PostListener {
        void onClick(DataPost dataPost);
    }

    public void setPosts(ArrayList<DataPost> posts) {
        this.posts = posts;

        notifyDataSetChanged();
    }

    public PostListener postListener;

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_post,
                parent,false

        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
        holder.bindData(posts.get(position), postListener);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemPostBinding binding;

        public ViewHolder(@NonNull ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(DataPost dataPost, PostListener postListener) {
            DetailPostViewModel viewModel = new DetailPostViewModelFactory(dataPost)
                    .create(DetailPostViewModel.class);

            binding.setViewModel(viewModel);
            binding.cvPost.setOnClickListener(view -> postListener.onClick(dataPost));
        }
    }

}
