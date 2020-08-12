package com.alfansyah.multidaya.androidbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;

import com.alfansyah.multidaya.androidbinding.databinding.ActivityPostBinding;
import com.alfansyah.multidaya.androidbinding.models.DataPost;
import com.alfansyah.multidaya.androidbinding.utils.ViewUtil;
import com.alfansyah.multidaya.androidbinding.viewmodel.DetailPostViewModel;
import com.alfansyah.multidaya.androidbinding.viewmodel.factories.DetailPostViewModelFactory;

public class PostActivity extends AppCompatActivity {

    ActivityPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post);

        DataPost dataPost = getIntent().getParcelableExtra(ThirdActivity.DATA_POST);

        if (dataPost != null) {
            ViewUtil.showArrowBack(this, dataPost.getTitle());

            DetailPostViewModel viewModel = new DetailPostViewModelFactory(dataPost)
                    .create(DetailPostViewModel.class);

            binding.setViewModel(viewModel);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        binding = null;
    }
}