package com.challenge.postman.ordenes.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.challenge.postman.ordenes.data.network.api_entities.LicenseActivationResponse
import com.challenge.postman.ordenes.data.network.api_entities.Order
import com.challenge.postman.ordenes.data.network.api_entities.OrderCopyResponse
import com.challenge.postman.ordenes.domain.OrdenesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdenesViewModel @Inject constructor(
    application: Application,
    private val ordenesRepository: OrdenesRepository
): AndroidViewModel(application) {
    private val _licenseActivationResponse = MutableLiveData<LicenseActivationResponse>()
    val licenseActivationResponse: LiveData<LicenseActivationResponse> = _licenseActivationResponse

    private val _todayOrders = MutableLiveData<List<Order>>()
    val todayOrders: LiveData<List<Order>> = _todayOrders

    private val _orderDetails = MutableLiveData<OrderCopyResponse>()
    val orderDetails: LiveData<OrderCopyResponse> = _orderDetails

    private val apiKey = MutableLiveData<String>()

    init {
        activateLicense()
        getTodayOrders()
    }

    private fun activateLicense() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = ordenesRepository.activateLicense()
            _licenseActivationResponse.postValue(response.value)
            apiKey.postValue(response.value?.data?.activation?.apiKey)
        }
    }

    private fun getTodayOrders() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = ordenesRepository.getTodayOrders()
            _todayOrders.postValue(response.value)
        }
    }

    fun getOrderDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = ordenesRepository.getOrderCopy()
            _orderDetails.postValue(response.value)
        }
    }
}