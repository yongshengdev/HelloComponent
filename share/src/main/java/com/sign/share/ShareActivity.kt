package com.sign.share

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sign.base.config.RouterConfig
import com.sign.share.databinding.ActivityShareBinding

@Route(path = RouterConfig.SHARE_ACTIVITY)
class ShareActivity : AppCompatActivity() {

    @JvmField
    @Autowired
    var shareTitle: String? = null

    private lateinit var binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ARouter.getInstance().inject(this);
        binding.btnShare.setOnClickListener {
            Toast.makeText(
                this@ShareActivity,
                "分享成功 shareTitle：$shareTitle",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}