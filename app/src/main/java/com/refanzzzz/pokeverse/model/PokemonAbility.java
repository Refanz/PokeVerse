package com.refanzzzz.pokeverse.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonAbility {

    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<Ability> abilityList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Ability> getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(List<Ability> abilityList) {
        this.abilityList = abilityList;
    }

    @Override
    public String toString() {
        return "PokemonAbility{" +
                "count=" + count +
                ", abilityList=" + abilityList +
                '}';
    }

    public class Ability {

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
            return "Ability{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public static class AbilityDetail {

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;

        public AbilityDetail(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "AbilityDetail{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
