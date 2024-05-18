package com.example.demo_app.ViewModel.API_Interface

import androidx.lifecycle.ViewModel

 open class BaseViewModel :ViewModel() {

     val apiRepository: Repository = Repository()

 }
