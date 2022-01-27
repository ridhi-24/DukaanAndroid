package com.example.dukaanandroid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectData  implements Serializable {
    @SerializedName("filter")
    @Expose
    private List<filterData> filter;
    @SerializedName("order")
    @Expose
    private List<Orderlist> order;

    public List<filterData> getFilter() {
        return filter;
    }

    public void setFilter(List<filterData> filter) {
        this.filter = filter;
    }

    public List<Orderlist> getOrder() {
        return order;
    }

    public void setOrder(List<Orderlist> order) {
        this.order = order;
    }
}

