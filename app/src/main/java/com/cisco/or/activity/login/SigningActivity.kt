package com.cisco.or.activity.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cisco.or.R
import com.cisco.or.activity.HomeActivity
import com.cisco.or.sdk.OpenRoaming
import com.cisco.or.databinding.ActivitySigningBinding

class SigningActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySigningBinding

    companion object {
        private val TAG = SigningActivity::class.java.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val service = intent.getSerializableExtra("service").toString()

        try {
            OpenRoaming.associateUser(
                binding.signingView,
                service,
                signingHandler = {
                    val intent = Intent(this, HomeActivity::class.java)
                    OpenRoaming.installProfile{
                        startActivity(intent)
                        finish()
                    }
                }
            )
        }
        catch (e: Exception){
            val toast = Toast.makeText(this, e.message, Toast.LENGTH_LONG)
            toast.show()
            Log.e(TAG, e.message.toString())
        }
    }
}
