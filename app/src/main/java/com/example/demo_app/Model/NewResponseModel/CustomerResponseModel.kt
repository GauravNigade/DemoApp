package com.example.demo_app.Model.NewResponseModel

data class CustomerResponseModel(
    val responseData: List<ResponseData>,
    val responseData1: ResponseData1,
    val statusCode: String,
    val statusMessage: String
)