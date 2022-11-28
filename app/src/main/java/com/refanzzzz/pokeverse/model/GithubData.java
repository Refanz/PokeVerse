package com.refanzzzz.pokeverse.model;

import com.google.gson.annotations.SerializedName;

public class GithubData {

    @SerializedName("name")
    private String name;
    @SerializedName("avatar_url")
    private String avatar;
    @SerializedName("public_repos")
    private int publicRepos;
    @SerializedName("followers")
    private int followers;
    @SerializedName("following")
    private int following;
    @SerializedName("location")
    private String location;
    @SerializedName("bio")
    private String bio;
    @SerializedName("twitter_username")
    private String twitterUsername;
    @SerializedName("blog")
    private String blog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "GithubData{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", publicRepos=" + publicRepos +
                ", followers=" + followers +
                ", following=" + following +
                ", location='" + location + '\'' +
                ", bio='" + bio + '\'' +
                ", twitterUsername='" + twitterUsername + '\'' +
                ", blog='" + blog + '\'' +
                '}';
    }
}
