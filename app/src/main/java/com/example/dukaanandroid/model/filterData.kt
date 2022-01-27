package com.example.dukaanandroid.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class filterData(
    @JsonProperty("count") var count: String? = "",
    @JsonProperty("id") var id: String? = "",
    @JsonProperty("name") var name: String? = "",

    ):Serializable
