package com.refanzzzz.pokeverse.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonItem {

    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<Item> pokeItemList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Item> getPokeItemList() {
        return pokeItemList;
    }

    public void setPokeItemList(List<Item> pokeItemList) {
        this.pokeItemList = pokeItemList;
    }

    @Override
    public String toString() {
        return "PokemonItem{" +
                "count=" + count +
                ", pokeItemList=" + pokeItemList +
                '}';
    }

    public class Item {

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("cost")
        private int cost;
        @SerializedName("sprites")
        private ItemSprite itemSprite;

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

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public ItemSprite getItemSprite() {
            return itemSprite;
        }

        public void setItemSprite(ItemSprite itemSprite) {
            this.itemSprite = itemSprite;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", cost=" + cost +
                    ", itemSprite=" + itemSprite +
                    '}';
        }
    }

    public class ItemSprite {
        @SerializedName("default")
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ItemSprite{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }
}
