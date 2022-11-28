package com.refanzzzz.pokeverse.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.refanzzzz.pokeverse.R;
import com.refanzzzz.pokeverse.model.GithubData;
import com.refanzzzz.pokeverse.retrofit.ApiService;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment {

    private View view;
    private CircleImageView ivUser;
    private AppCompatTextView tvFollowers, tvFollowing, tvGithubName, tvBio, tvLocation,
            tvRepository, tvTwitterUsername, tvBlog;
    private static final String TAG = "UserFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_user, container, false);

        hideActionBar();

        init();

        getDataGithub();

        return view;
    }

    void getDataGithub() {
        ApiService.getService2().getGithub().enqueue(new Callback<GithubData>() {
            @Override
            public void onResponse(Call<GithubData> call, Response<GithubData> response) {
               if(response.body() != null) {
                   try {
                       String name = response.body().getName();
                       String avatar = response.body().getAvatar();
                       String bio = response.body().getBio();
                       int followers = response.body().getFollowers();
                       int following = response.body().getFollowing();
                       String location = response.body().getLocation();
                       int repository = response.body().getPublicRepos();
                       String twitterUsername = response.body().getTwitterUsername();
                       String blog = response.body().getBlog();

                       Glide.with(view.getContext()).load(avatar).into(ivUser);
                       tvGithubName.setText(name);
                       tvBio.setText(bio);
                       tvFollowers.setText(String.valueOf(followers));
                       tvFollowing.setText(String.valueOf(following));
                       tvLocation.setText(location);
                       tvRepository.setText(String.valueOf(repository));
                       tvTwitterUsername.setText(twitterUsername);
                       tvBlog.setText(blog);
                   } catch (Exception e) {
                       Log.d(TAG, e.getMessage());
                   }
               }
            }

            @Override
            public void onFailure(Call<GithubData> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    void hideActionBar() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    void init() {
        ivUser = view.findViewById(R.id.iv_avatar);
        tvFollowers = view.findViewById(R.id.tv_followers);
        tvFollowing = view.findViewById(R.id.tv_following);
        tvGithubName = view.findViewById(R.id.tv_github_name);
        tvBio = view.findViewById(R.id.tv_bio);
        tvLocation = view.findViewById(R.id.tv_github_location);
        tvRepository = view.findViewById(R.id.tv_github_repository);
        tvTwitterUsername = view.findViewById(R.id.tv_github_twitter);
        tvBlog = view.findViewById(R.id.tv_github_blog);
    }
}