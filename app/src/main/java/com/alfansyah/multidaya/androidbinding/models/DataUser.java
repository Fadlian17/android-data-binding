package com.alfansyah.multidaya.androidbinding.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DataUser {


    private int perPage;

    private int total;

    private Ad ad;

    private List<DataItem> data;

    private int page;

    private int totalPages;

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public Ad getAd() {
        return ad;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }
}