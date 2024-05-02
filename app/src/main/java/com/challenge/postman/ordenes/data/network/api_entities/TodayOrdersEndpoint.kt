package com.challenge.postman.ordenes.data.network.api_entities

import com.google.gson.annotations.SerializedName

data class TodayOrdersRequest(
    @SerializedName("apk_version") val apkVersion: String,
    @SerializedName("apk_code") val apkCode: Int,
    @SerializedName("area_id") val areaId: Int,
    val tables: Boolean,
    val tabs: Boolean
)

data class TodayOrdersResponse(
    val response: List<Order>,
    // TODO:
)

data class Order(
    val body: String
    // TODO:
)

data class OrderCopyRequest(
    @SerializedName("order_id") val orderId: String
)

data class OrderCopyResponse(
    val response: String,
    // TODO:
)