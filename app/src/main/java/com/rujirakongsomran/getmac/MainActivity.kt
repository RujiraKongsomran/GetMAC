package com.rujirakongsomran.getmac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rujirakongsomran.getmac.databinding.ActivityMainBinding
import java.net.NetworkInterface
import java.util.*

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        setContentView(binding.root)
        var macNumber = getMacAddress()
        binding.tvMAC.text = macNumber
    }

    private fun getMacAddress(): String? {
        try {
            val networkInterfaceList: List<NetworkInterface> =
                Collections.list(NetworkInterface.getNetworkInterfaces())
            for (networkInterface in networkInterfaceList) {
                if (networkInterface.name != "wlan0") {
                    continue
                }
                val macAddress: ByteArray = networkInterface.hardwareAddress ?: return ""
                val result = StringBuilder()
                for (data in macAddress) {
                    result.append(Integer.toHexString(data.toInt() and 0xFF)).append(":")
                }
                if (result.isNotEmpty()) {
                    result.deleteCharAt(result.length - 1)
                }
                return result.toString()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "02:00:00:00:00:00"
    }
}