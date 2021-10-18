package com.example.retrofitej1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitej1.Modelo.Post;

public class MainActivity extends AppCompatActivity {
    private TextView tvMostrar;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMostrar=findViewById(R.id.tvMostrar);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getPostMutableLiveData().observe(this, new Observer<Post>() {
            @Override
            public void onChanged(Post post) {
                tvMostrar.setText(post.getBody());
            }
        });

        vm.leerPost();

    }

}