package com.main.myislamiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.main.myislamiapp.databinding.ActivitySplashBinding
import com.main.myislamiapp.quran.MainActivity

class SplashActivity : AppCompatActivity() {
    lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({startHomeActivity()},3000)
    }
    private fun startHomeActivity(){
        val intent=Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}