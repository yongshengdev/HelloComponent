package com.sign.hellocomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.sign.componentbase.service.ServiceFactory
import com.sign.hellocomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShare.setOnClickListener {
            if (!TextUtils.isEmpty(ServiceFactory.getInstance().getLoginService().getAccountId())) {
                ARouter.getInstance().build("/share/share").withString(
                    "accountId",
                    ServiceFactory.getInstance().getLoginService().getAccountId()
                ).navigation()
            } else {
                ARouter.getInstance().build("/account/login").navigation()
            }
        }
    }
}