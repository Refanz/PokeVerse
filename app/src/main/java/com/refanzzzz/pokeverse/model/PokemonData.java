package com.refanzzzz.pokeverse.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonData {

    @SerializedName("count")
    private int count;
    @SerializedName("next")
    private String nextUrl;
    @SerializedName("previous")
    private String previousUrl;
    @SerializedName("results")
    private List<Data> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public String getPreviousUrl() {
        return previousUrl;
    }

    public void setPreviousUrl(String previousUrl) {
        this.previousUrl = previousUrl;
    }

    public List<Data> getResults() {
        return results;
    }

    public void setResult(List<Data> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PokemonData{" +
                "count=" + count +
                ", nextUrl='" + nextUrl + '\'' +
                ", previousUrl='" + previousUrl + '\'' +
                ", result=" + results +
                '}';
    }

    public class Data {

        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
