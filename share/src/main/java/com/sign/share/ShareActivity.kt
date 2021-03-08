package com.sign.share

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sign.componentbase.service.ServiceFactory
import kotlinx.android.synthetic.main.activity_share.*

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        btn_login.setOnClickListener {
            val text = if (ServiceFactory.getInstance().getLoginService()
                    .isLogin()
            ) "分享成功" else "分享失败，账号未登录"
            Toast.makeText(this@ShareActivity, text, Toast.LENGTH_LONG).show()
        }
    }
}