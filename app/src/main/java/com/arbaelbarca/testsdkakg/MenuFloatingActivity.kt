package com.arbaelbarca.testsdkakg

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.akggame.akg_sdk.AKG_SDK
import com.akggame.akg_sdk.MenuSDKCallback
import com.akggame.akg_sdk.PAYMENT_TYPE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu_floating.*

class MenuFloatingActivity : AppCompatActivity(), MenuSDKCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_floating)

        AKG_SDK.callBannerDialog(this)
        setFLoating()

        btnProductGoogle.setOnClickListener {
            AKG_SDK.onSDKPayment(PAYMENT_TYPE.GOOGLE, this)
        }

        btnProductOttopay.setOnClickListener {
            AKG_SDK.onSDKPayment(PAYMENT_TYPE.OTTOPAY, this)
        }

    }



    private fun setFLoating() {
        AKG_SDK.setFloatingButton(this, floatingButton, this, this)
        floatingButton.setFloat()
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCheckSDK(isUpdated: Boolean) {
        showToast("Suksse check SDK")
    }

    override fun onClickEula(context: Context) {
        showToast("Sukses eula")
    }

    override fun onClickFbPage(context: Context) {
        showToast("Sukses fbfanpage")
    }

    override fun onContactUs(context: Context) {
        showToast("Sukses contactus")
    }

    override fun onLogout() {
        showToast("Sukses logout")
    }

    override fun onSuccessBind(token: String, loginType: String) {
        showToast("Sukses bind")
    }
}