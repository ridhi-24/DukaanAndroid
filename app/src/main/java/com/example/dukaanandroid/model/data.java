package com.example.dukaanandroid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;



@JsonIgnoreProperties(ignoreUnknown = true)
public class data<T> implements Serializable {

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Expose
    @SerializedName("count")
    private int status;
    @Expose
    @SerializedName("results")
    private T results;


}
