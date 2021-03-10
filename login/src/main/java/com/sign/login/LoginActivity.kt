package com.sign.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sign.login.databinding.ActivityLoginBinding
import com.sign.login.manage.AccountManager

@Route(path = "/account/login")
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
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
            if (TextUtils.isEmpty(AccountManager.accountId)) {
                Toast.makeText(this@LoginActivity, "请先登陆", Toast.LENGTH_LONG).show()
            } else {
                ARouter.getInstance().build("/share/share")
                    .withString("shareTitle", "This is share Title.").navigation()
            }
        }
        updateAccountStatus()
    }

    private fun updateAccountStatus() {
        if (TextUtils.isEmpty(AccountManager.accountId)) {
            binding.tvState.text = "当前状态：未登录"
        } else {
            binding.tvState.text = "当前状态：已登录 用户id：" + AccountManager.accountId
        }
    }
}