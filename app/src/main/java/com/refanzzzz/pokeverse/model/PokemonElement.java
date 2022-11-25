package com.refanzzzz.pokeverse.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonElement {

    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<Element> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Element> getResults() {
        return results;
    }

    public void setResults(List<Element> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PokemonElement{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }

    public class Element {

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
            return "ELement{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
