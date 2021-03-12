package com.sign.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.sign.base.config.RouterConfig
import com.sign.componentbase.service.ServiceFactory
import com.sign.login.databinding.LoginActivityLoginBinding
import com.sign.login.manage.AccountManager

@Route(path = RouterConfig.LOGIN_ACTIVITY)
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            AccountManager.accountId = "3721"
            updateAccountStatus()
        }
        binding.btnExit.setOnClickListener {
            AccountManager.accountId = null
            updateAccountStatus()
        }
        binding.btnShare.setOnClickListener {
            ARouter.getInstance().build(RouterConfig.SHARE_ACTIVITY)
                .withString(
                    RouterConfig.Params.SHARE_TITLE,
                    "This is share Title from LoginActivity."
                )
                .navigation(this@LoginActivity, object : NavigationCallback {
                    override fun onLost(postcard: Postcard?) {

                    }

                    override fun onFound(postcard: Postcard?) {

                    }

                    // 注意：在子线程中回调
                    override fun onInterrupt(postcard: Postcard?) {
                        runOnUiThread {
                            Toast.makeText(this@LoginActivity, "请先登陆", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onArrival(postcard: Postcard?) {

                    }

                })
        }
        updateAccountStatus()
    }

    private fun updateAccountStatus() {
        if (!ServiceFactory.getInstance().getLoginService().isLogin()) {
            binding.tvState.text = "当前状态：未登录"
        } else {
            binding.tvState.text =
                "当前状态：已登录 用户id：" + ServiceFactory.getInstance().getLoginService().getAccountId()
        }
    }
}