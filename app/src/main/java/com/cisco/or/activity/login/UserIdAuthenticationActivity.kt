package com.cisco.or.activity.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cisco.or.R
import com.cisco.or.activity.HomeActivity
import com.cisco.or.databinding.UserIdBasedBinding
import com.cisco.or.sdk.OpenRoaming
import com.cisco.or.sdk.enums.IdType
import com.cisco.or.sdk.exceptions.EmailException

class UserIdAuthenticationActivity : AppCompatActivity() {

    companion object {
        private val TAG = UserIdAuthenticationActivity::class.java.name
    }

    private lateinit var binding: UserIdBasedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserIdBasedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()

        binding.buttonContinue.setOnClickListener {
            val value = binding.editTextValue.text.toString()
            if(value.isNullOrBlank() || value.isNullOrEmpty()) {
                Toast.makeText(this, R.string.email_required, Toast.LENGTH_SHORT).show()
            } else {
                try {
                    OpenRoaming.associateUser(IdType.EMAIL, value, signingHandler = {
                        OpenRoaming.installProfile {
                            startHomeActivity()
                        }
                    })
                } catch (e: EmailException) {
                    Toast.makeText(this, R.string.invalid_email, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun startHomeActivity() {
        try {
            runOnUiThread {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        } catch(e: Exception) {
            Log.e(TAG, Log.getStackTraceString(e))
        }
    }
}