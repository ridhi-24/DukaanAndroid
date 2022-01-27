package com.example.dukaanandroid.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
data class Orderlist(
    @JsonProperty("id") var id: String? = "",
    @JsonProperty("is_new") var isNew: String? = "",
    @JsonProperty("timestamp") var timestamp: String? = "",
    @JsonProperty("item_count") var itemCount: String? = "",
    @JsonProperty("price") var price: String? = "",
    @JsonProperty("status") var status: String? = "",
    @JsonProperty("type") var type: String? = "",
    @JsonProperty("thumbnail") var thumbnail: String? = "",

):Serializable
