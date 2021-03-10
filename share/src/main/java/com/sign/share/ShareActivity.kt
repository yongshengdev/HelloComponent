package com.sign.share

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.sign.componentbase.service.ServiceFactory
import com.sign.share.databinding.ActivityShareBinding

@Route(path = "/share/share")
class ShareActivity : AppCompatActivity() {

    @JvmField
    @Autowired
    var accountId: String? = null

    private lateinit var binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShare.setOnClickListener {
            val text = if (ServiceFactory.getInstance().getLoginService()
                    .isLogin()
            ) "分享成功 shareTitle：${intent.getStringExtra("shareTitle")}" else "分享失败，账号未登录"
            Toast.makeText(this@ShareActivity, text, Toast.LENGTH_LONG).show()
        }
    }
}