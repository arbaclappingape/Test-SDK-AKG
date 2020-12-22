package com.arbaelbarca.testsdkakg

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akggame.akg_sdk.*
import com.akggame.akg_sdk.AKG_SDK.onLogin
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Hawk.init(this)
                .build()



        if (AKG_SDK.checkIsLogin(this)) {
            AKG_SDK.setRelauchDialog(this, object : RelaunchSDKCallback {
                override fun onContinue() {
                    Toast.makeText(this@MainActivity, "onContinue", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@MainActivity, MenuFloatingActivity::class.java))
                    finish()
                }

                override fun onReLogin() {
                    Toast.makeText(this@MainActivity, "onRelogin", Toast.LENGTH_LONG).show()
                    callLogin()
                }
            })
        } else {
            callLogin() //441
        }
    }


    private fun callLogin() {
        onLogin(this, object : LoginSDKCallback {
            override fun onResponseSuccess(s: String, s1: String, s2: String) {
                val intent = Intent(this@MainActivity, MenuFloatingActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }

            override fun onResponseFailed(s: String) {

            }
        })
    }


}