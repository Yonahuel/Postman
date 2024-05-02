package com.challenge.postman.ordenes.data.network

import com.challenge.postman.ordenes.data.network.api_entities.LicenseActivationRequest
import com.challenge.postman.ordenes.data.network.api_entities.LicenseActivationResponse
import com.challenge.postman.ordenes.data.network.api_entities.OrderCopyRequest
import com.challenge.postman.ordenes.data.network.api_entities.OrderCopyResponse
import com.challenge.postman.ordenes.data.network.api_entities.TodayOrdersRequest
import com.challenge.postman.ordenes.data.network.api_entities.TodayOrdersResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("license/activate")
    suspend fun activateLicense(@Body requestBody: LicenseActivationRequest): LicenseActivationResponse

    @POST("orders/today-orders")
    suspend fun getTodayOrders(@Body requestBody: TodayOrdersRequest): TodayOrdersResponse

    @POST("orders/get-order")
    suspend fun getOrderCopy(@Body requestBody: OrderCopyRequest): OrderCopyResponse
}