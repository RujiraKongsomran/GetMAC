package com.rujirakongsomran.getmac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rujirakongsomran.getmac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        setContentView(binding.root)
        binding.tvMAC.text = "ZZZZ"
    }
}