package com.challenge.postman.ordenes.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.challenge.postman.common.data.network.RetrofitInstance
import com.challenge.postman.ordenes.data.network.api_entities.LicenseActivationRequest
import com.challenge.postman.ordenes.data.network.api_entities.LicenseActivationResponse
import com.challenge.postman.ordenes.data.network.api_entities.Order
import com.challenge.postman.ordenes.data.network.api_entities.OrderCopyRequest
import com.challenge.postman.ordenes.data.network.api_entities.OrderCopyResponse
import com.challenge.postman.ordenes.data.network.api_entities.TodayOrdersRequest
import com.challenge.postman.ordenes.data.network.api_entities.TodayOrdersResponse
import retrofit2.HttpException

class OrdenesRepository {
    private val tag = "OrdenesRepository"
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val licenseActivationRequest = LicenseActivationRequest(
        serial = "1234567890",
        deviceId = "device_id",
        deviceInformation = "Device information",
        hostname = "Hostname"
    )

    private val todayOrdersRequest = TodayOrdersRequest(
        apkVersion = "standard",
        apkCode = 228,
        areaId = 0,
        tables = false,
        tabs = true
    )

    private val orderCopyRequest = OrderCopyRequest(
        orderId = "00000"
    )

    suspend fun activateLicense(
        request: LicenseActivationRequest = licenseActivationRequest
    ): LiveData<LicenseActivationResponse> {
        val activationResponse = MutableLiveData<LicenseActivationResponse>()

        try {
            val response = RetrofitInstance.apiService.activateLicense(request)
            activationResponse.value = response
        } catch (e: Exception) {
            handleError(e)
        }

        return activationResponse
    }

    suspend fun getTodayOrders(
        request: TodayOrdersRequest = todayOrdersRequest
    ): LiveData<List<Order>> {
        val ordersResponse = MutableLiveData<List<Order>>()

        try {
            val response = RetrofitInstance.apiService.getTodayOrders(request)
            ordersResponse.value = response.response
        } catch (e: Exception) {
            handleError(e)
        }

        return ordersResponse
    }

    suspend fun getOrderCopy(
        request: OrderCopyRequest = orderCopyRequest
    ): LiveData<OrderCopyResponse> {
        val orderResponse = MutableLiveData<OrderCopyResponse>()

        try {
            val response = RetrofitInstance.apiService.getOrderCopy(request)
            orderResponse.value = response
        } catch (e: Exception) {
            handleError(e)
        }
        return orderResponse
    }

    private fun handleError(exception: Throwable) {
        val message = if (exception is HttpException) {
            "Error ${exception.message}"
        } else {
            "$tag - Error de red: ${exception.message}"
        }
        _error.postValue(message)
    }
}