package com.example.mvvm_login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val textWelcome = MutableLiveData("Olá! Bem Vindo")
    var login = MutableLiveData<String>()

    fun doLogin(name: String, password: String) {
        if(name != "" && password != "") {
            login.value = "SUCESSO!"
        } else {
            login.value = "Falha no login"
        }
    }
}