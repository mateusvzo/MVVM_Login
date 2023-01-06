package com.example.mvvm_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonLogin.setOnClickListener(this)

        createObserver()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_login) {
            val name = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            viewModel.doLogin(name, password)
        }
    }

    private fun createObserver() {
        viewModel.textWelcome.observe(this, Observer {
            binding.textWelcome.text = it
        })
        viewModel.login.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }
}