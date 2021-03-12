package com.sign.hellocomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.sign.base.config.RouterConfig
import com.sign.hellocomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("test", "onCreate currentThread: ${Thread.currentThread()}")
        binding.btnShare.setOnClickListener {
            ARouter.getInstance().build(RouterConfig.SHARE_ACTIVITY).withString(
                RouterConfig.Params.SHARE_TITLE,
                "This is share Title from MainActivity."
            ).navigation(this@MainActivity, object : NavigationCallback {
                override fun onLost(postcard: Postcard?) {

                }

                override fun onFound(postcard: Postcard?) {

                }

                // 注意：在子线程中回调
                override fun onInterrupt(postcard: Postcard?) {
                    Log.d("test", "onInterrupt currentThread: ${Thread.currentThread()}")
                    runOnUiThread {
                        Toast.makeText(this@MainActivity, "请先登陆", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onArrival(postcard: Postcard?) {

                }

            })
        }
        binding.btnLogin.setOnClickListener {
            ARouter.getInstance().build(RouterConfig.LOGIN_ACTIVITY).navigation()
        }
        binding.btnToHome.setOnClickListener {
            ARouter.getInstance().build(RouterConfig.HOME_ACTIVITY).navigation()
        }
    }
}